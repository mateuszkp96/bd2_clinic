package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Patient;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient getSinglePatient(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}
