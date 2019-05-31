package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Surgery;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.SurgeryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurgeryService {
    private final SurgeryRepository repository;

    public Surgery findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surgery", "id", id));
    }

    public List<Surgery> getAll() {
        return repository.findAll();
    }

    public Surgery save(Surgery surgery) {
        return repository.save(surgery);
    }

    public void deleteByID(Long id) {
        repository.deleteById(id);
    }
}
