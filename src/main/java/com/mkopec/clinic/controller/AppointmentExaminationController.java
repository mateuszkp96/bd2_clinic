package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.AppointmentExamination;
import com.mkopec.clinic.dtos.AppointmentExaminationDTO;
import com.mkopec.clinic.dtos.AppointmentExaminationPostDTO;
import com.mkopec.clinic.mapper.AppointmentExaminationMapper;
import com.mkopec.clinic.service.AppointmentExaminationService;
import com.mkopec.clinic.service.AppointmentService;
import com.mkopec.clinic.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment/examination")
public class AppointmentExaminationController {
    private final AppointmentExaminationService appointmentExaminationService;
    private final AppointmentExaminationMapper appointmentExaminationMapper;

    private final AppointmentService appointmentService;
    private final ExaminationService examinationService;

    @GetMapping("/{id}")
    public List<AppointmentExaminationDTO> findByAppointmentID(@PathVariable Long id) {
        Appointment appointment = appointmentService.findByID(id);
        return appointmentExaminationMapper.toAppointmentExaminationDTOs(appointmentExaminationService.findByAppointment(appointment));
    }

    @PostMapping
    public AppointmentExaminationPostDTO addAppointmentExaminationToAppointment(@RequestBody AppointmentExaminationPostDTO dto) {
        AppointmentExamination examination = appointmentExaminationMapper.toAppoinmentExamination(dto);
        examination.setName(examinationService.findByID(dto.getExaminationID()).getName());
        return appointmentExaminationMapper.toAppointmentExaminationPostDTO(appointmentExaminationService.save(examination));
    }
}
