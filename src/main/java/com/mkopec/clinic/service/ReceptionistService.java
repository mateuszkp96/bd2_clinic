package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Receptionist;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.ReceptionistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceptionistService {
    private final ReceptionistRepository repository;

    public Receptionist findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Receptionist", "id", id));
    }

    public List<Receptionist> getAll() {
        return repository.findAll();
    }

    public Receptionist save(Receptionist receptionist) {
        return repository.save(receptionist);
    }
}
