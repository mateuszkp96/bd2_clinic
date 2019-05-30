package com.mkopec.clinic.controller;

import com.mkopec.clinic.dtos.DoctorDTO;
import com.mkopec.clinic.mapper.DoctorMapper;
import com.mkopec.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorMapper.toDoctorDTOs(doctorService.getAllDoctors());
    }
}
