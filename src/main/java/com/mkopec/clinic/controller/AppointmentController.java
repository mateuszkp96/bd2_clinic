package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.*;
import com.mkopec.clinic.dtos.*;
import com.mkopec.clinic.mapper.AppointmentDateMapper;
import com.mkopec.clinic.mapper.AppointmentMapper;
import com.mkopec.clinic.projections.AppointmentDate;
import com.mkopec.clinic.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final PatientCardService patientCardService;

    private final ShiftPartService shiftPartService;
    private final AppointmentDateMapper appointmentDateMapper;

    @GetMapping("/details/{appointmentID}")
    public AppointmentDetailsDTO getAppointmentDetails(@PathVariable Long appointmentID) {
        Appointment appointment = appointmentService.findByID(appointmentID);
        return appointmentMapper.toAppointmentDetailsDTO(appointment);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<DoctorAppointmentDTO> getTodayAppointments(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.findByDateAndDoctorID(Calendar.getInstance(), doctorId);
        return appointmentMapper.toDoctorAppointmentDTOs(appointments);
    }

    @GetMapping("/byDoctor/{id}")
    public List<AppointmentDateDTO> getAppointmentDatesByDoctor(@PathVariable Long id) {
        Calendar from = Calendar.getInstance();

        Calendar to = Calendar.getInstance();
        to.add(Calendar.YEAR, 1);

        List<AppointmentDate> dates = appointmentService.findAppointmentDates(from, to, new ArrayList<>(Arrays.asList(id)));
        return appointmentDateMapper.toAppointmentDateDTOs(dates);
    }

    @GetMapping("/bySpecialization/{id}")
    public List<AppointmentDateDTO> getAppointmentDatesBySpecialization(@PathVariable Long id) {
        List<Long> doctorsIDs = doctorService.findBySpecializationID(id);

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        to.add(Calendar.YEAR, 1);

        List<AppointmentDate> dates = appointmentService.findAppointmentDates(from, to, new ArrayList<>(doctorsIDs));
        return appointmentDateMapper.toAppointmentDateDTOs(dates);
    }

    @PostMapping
    public AppointmentPostDTO saveAppointment(@RequestBody AppointmentPostDTO appointmentPostDTO) {
        Appointment appointment = appointmentMapper.toAppointment(appointmentPostDTO);

        Patient patient = patientService.getSinglePatient(appointmentPostDTO.getPatientID());
        Doctor doctor = doctorService.findByID(appointmentPostDTO.getDoctorID());

        PatientCard patientCard = patientCardService.findByDoctorAndPatient(doctor, patient);
        if (Objects.isNull(patientCard)) {
            patientCard = patientCardService.save(createPatientCard(doctor, patient));
        }
        appointment.setPatientCard(patientCard);

        ShiftPart shiftPart = shiftPartService.findByID(appointmentPostDTO.getShiftPartID());
        appointment.setShiftPart(shiftPart);
        appointment.setShift(shiftPart.getShift());

        return appointmentMapper.toAppointmentPostDTO(appointmentService.save(appointment));
    }

    private PatientCard createPatientCard(Doctor doctor, Patient patient) {
        PatientCard card = new PatientCard();
        card.setDoctor(doctor);
        card.setPatient(patient);
        card.setFirstname(patient.getFirstname());
        card.setSurname(patient.getSurname());
        card.setPesel(patient.getIdentityNumber());
        card.setCreateDate(Calendar.getInstance());
        return card;
    }

    @GetMapping("/patientCard")
    public List<ShortAppointmentDTO> getAppointments(@RequestParam(name = "patientID") Long patientID,
                                                     @RequestParam(name = "doctorID") Long doctorID) {
        PatientCard patientCard = patientCardService.findByDoctorIDAndPatientID(doctorID, patientID);
        if (Objects.nonNull(patientCard)) {
            return appointmentMapper.toShortAppointmentDTOs(patientCard.getAppointments());
        }
        return null;
    }
}
