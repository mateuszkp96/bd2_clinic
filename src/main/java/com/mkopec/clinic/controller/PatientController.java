package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Address;
import com.mkopec.clinic.domain.Patient;
import com.mkopec.clinic.dtos.PatientDTO;
import com.mkopec.clinic.dtos.PatientPostDTO;
import com.mkopec.clinic.dtos.ShortPatientDTO;
import com.mkopec.clinic.mapper.PatientMapper;
import com.mkopec.clinic.service.AddressService;
import com.mkopec.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final AddressService addressService;
    private final PatientMapper patientMapper;

    @GetMapping
    public List<ShortPatientDTO> getAllPatients() {
        return patientMapper.toShortPatientDTOs(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public PatientDTO getSinglePatient(@PathVariable Long id) {
        return patientMapper.toPatientDTO(patientService.getSinglePatient(id));
    }

    @PostMapping
    public PatientDTO savePatient(@RequestBody PatientPostDTO patientPostDTO) {
        Patient patient = patientMapper.toPatient(patientPostDTO);

        Address address = addressService.getAddress(patient.getAddress());
        patient.setAddress(address);

        return patientMapper.toPatientDTO(patientService.savePatient(patient));
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
