package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Clinic;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicRepository repository;

    public Clinic findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
    }

    public List<Clinic> getAll() {
        return repository.findAll();
    }
}
