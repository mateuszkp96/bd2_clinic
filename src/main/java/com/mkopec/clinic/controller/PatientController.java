package com.mkopec.clinic.controller;

import com.mkopec.clinic.dtos.PatientDTO;
import com.mkopec.clinic.dtos.ShortPatientDTO;
import com.mkopec.clinic.mapper.PatientMapper;
import com.mkopec.clinic.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    private final PatientMapper patientMapper;

    public PatientController(PatientService patientService, PatientMapper patientMapper) {
        this.patientService = patientService;
        this.patientMapper = patientMapper;
    }

    @GetMapping
    public List<ShortPatientDTO> getAllPatients() {
        return patientMapper.toShortPatientDTOs(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public PatientDTO getSinglePatient(@PathVariable Long id) {
        return patientMapper.toPatientDTO(patientService.getSinglePatient(id));
    }
}
