package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Examination;
import com.mkopec.clinic.dtos.ExaminationDTO;
import com.mkopec.clinic.dtos.ExaminationPostDTO;
import com.mkopec.clinic.mapper.ExaminationMapper;
import com.mkopec.clinic.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/examination")
public class ExaminationController {
    private final ExaminationService service;
    private final ExaminationMapper mapper;

    @GetMapping
    public List<ExaminationDTO> getAllParts() {
        return mapper.toExaminationDTOs(service.findAll());
    }

    @GetMapping("/{id}")
    public ExaminationDTO findByID(@PathVariable Long id) {
        return mapper.toExaminationDTO(service.findByID(id));
    }

    @PostMapping
    public ExaminationPostDTO postExamination(@RequestBody ExaminationPostDTO examinationPostDTO) {
        Examination examination = mapper.toExamination(examinationPostDTO);
        return mapper.toExaminationPostDTO(service.save(examination));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
