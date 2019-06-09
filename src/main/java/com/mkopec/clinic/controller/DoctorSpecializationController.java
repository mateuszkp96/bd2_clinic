package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.DoctorSpecialization;
import com.mkopec.clinic.domain.Specialization;
import com.mkopec.clinic.dtos.DoctorSpecializationDTO;
import com.mkopec.clinic.dtos.DoctorSpecializationPostDTO;
import com.mkopec.clinic.mapper.DoctorSpecializationMapper;
import com.mkopec.clinic.service.DoctorService;
import com.mkopec.clinic.service.DoctorSpecializationService;
import com.mkopec.clinic.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctorspecialization")
public class DoctorSpecializationController {
    private final DoctorSpecializationService service;
    private final DoctorSpecializationMapper mapper;

    private final SpecializationService specializationService;
    private final DoctorService doctorService;

    @GetMapping("/{id}")
    public DoctorSpecializationDTO getById(@PathVariable Long id) {
        return mapper.toDoctorSpecializationDTO(service.findByID(id));
    }

    @GetMapping
    public List<DoctorSpecializationDTO> getAll() {
        return mapper.toDoctorSpecializationDTOs(service.getAll());
    }

    @PostMapping
    public DoctorSpecializationPostDTO saveDoctorSpecialization(@RequestBody DoctorSpecializationPostDTO specializationPostDTO) {
        Specialization specialization = specializationService.findByID(specializationPostDTO.getSpecializationID());
        Doctor doctor = doctorService.findByID(specializationPostDTO.getDoctorID());

        DoctorSpecialization doctorSpecialization = mapper.toDoctorSpecialization(specializationPostDTO);
        doctorSpecialization.setSpecializationID(specialization.getId());
        doctorSpecialization.setSpecializationName(specialization.getName());
        doctorSpecialization.setDoctor(doctor);

        DoctorSpecialization savedSpecialization = service.save(doctorSpecialization);

        return mapper.toDoctorSpecializationPostDTO(savedSpecialization);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorSpecialization(@PathVariable Long id) {
        service.delete(id);
    }
}
