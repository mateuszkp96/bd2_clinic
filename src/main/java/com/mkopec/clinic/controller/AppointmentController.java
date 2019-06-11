package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.*;
import com.mkopec.clinic.dtos.AppointmentDTO;
import com.mkopec.clinic.dtos.AppointmentPostDTO;
import com.mkopec.clinic.dtos.ShiftPartDTO;
import com.mkopec.clinic.mapper.AppointmentMapper;
import com.mkopec.clinic.mapper.ShiftPartMapper;
import com.mkopec.clinic.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final PatientCardService patientCardService;

    private final ShiftService shiftService;
    private final ShiftPartService shiftPartService;
    private final ShiftPartMapper shiftPartMapper;

    @GetMapping
    public List<AppointmentDTO> getAll() {
        return appointmentMapper.toAppointmentDTOs(appointmentService.findAll());
    }

    @GetMapping("/{date}/{shiftID}")
    public List<ShiftPartDTO> getPossibleShiftParts(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @PathVariable Long shiftID) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Shift shift = shiftService.findByID(shiftID);
        List<ShiftPart> doctorShiftParts = shiftPartService.findByShift(shift);
        List<ShiftPart> shiftPartsWithAppointments = appointmentService.findByDateAndShift(calendar, shift);

        doctorShiftParts.removeAll(shiftPartsWithAppointments);

        return shiftPartMapper.toShiftPartDTOs(doctorShiftParts);
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

        appointment.setDate(getDateFromDTO(appointmentPostDTO));

        return appointmentMapper.toAppointmentPostDTO(appointmentService.save(appointment));
    }

    private Calendar getDateFromDTO(AppointmentPostDTO dto) {
        Calendar c = Calendar.getInstance();
        c.set(dto.getDateYear(), dto.getDateMonth() - 1, dto.getDateDay());
        c.get(Calendar.MONTH);
        return c;
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
}
