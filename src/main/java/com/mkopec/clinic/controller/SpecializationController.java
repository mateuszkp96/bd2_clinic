package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Specialization;
import com.mkopec.clinic.dtos.SpecializationDTO;
import com.mkopec.clinic.dtos.SpecializationPostDTO;
import com.mkopec.clinic.mapper.SpecializationMapper;
import com.mkopec.clinic.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialization")
public class SpecializationController {
    private final SpecializationService service;
    private final SpecializationMapper mapper;

    @GetMapping("/{id}")
    public SpecializationDTO getById(@PathVariable Long id) {
        return mapper.toSpecializationDTO(service.findByID(id));
    }

    @GetMapping
    public List<SpecializationDTO> getAll() {
        return mapper.toSpecializationDTOs(service.getAll());
    }

    @PostMapping
    public SpecializationPostDTO saveSpecialization(@RequestBody SpecializationPostDTO specializationPostDTO) {
        Specialization savedSpecialization = service.save(mapper.toSpecialization(specializationPostDTO));
        return mapper.toSpecializationPostDTO(savedSpecialization);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialization(@PathVariable Long id) {
        service.delete(id);
    }
}
