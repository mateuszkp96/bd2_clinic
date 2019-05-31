package com.mkopec.clinic.controller;

import com.mkopec.clinic.dtos.ClinicDTO;
import com.mkopec.clinic.dtos.ShortClinicDTO;
import com.mkopec.clinic.mapper.ClinicMapper;
import com.mkopec.clinic.service.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clinic")
public class ClinicController {
    private final ClinicService clinicService;
    private final ClinicMapper clinicMapper;

    @GetMapping
    public List<ShortClinicDTO> getAllClinics() {
        return clinicMapper.toShortClinicDTOs(clinicService.getAll());
    }

    @GetMapping("/{id}")
    public ClinicDTO getClinicById(@PathVariable Long id) {
        return clinicMapper.toClinicDTO(clinicService.findByID(id));
    }
}
