package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.ScopeOfExamination;
import com.mkopec.clinic.dtos.ScopeOfExaminationDTO;
import com.mkopec.clinic.mapper.ScopeOfExaminationMapper;
import com.mkopec.clinic.service.ScopeOfExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scopeOfExamination")
public class ScopeOfExaminationController {
    private final ScopeOfExaminationService service;
    private final ScopeOfExaminationMapper mapper;

    @GetMapping
    public List<ScopeOfExaminationDTO> getAllParts() {
        return mapper.toScopeOfExaminationDTOs(service.findAll());
    }

    @GetMapping("/{id}")
    public ScopeOfExaminationDTO findByID(@PathVariable Long id) {
        return mapper.toScopeOfExaminationDTO(service.findByID(id));
    }

    @PostMapping
    public ScopeOfExaminationDTO postScopeOfExamination(@RequestBody ScopeOfExaminationDTO scopeOfExaminationDTO) {
        ScopeOfExamination examination = mapper.toScopeOfExamination(scopeOfExaminationDTO);
        return mapper.toScopeOfExaminationDTO(service.save(examination));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
