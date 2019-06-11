package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Examination;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.ExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExaminationService {
    private final ExaminationRepository repository;

    public Examination save(Examination appointment) {
        return repository.save(appointment);
    }

    public List<Examination> findAll() {
        return repository.findAll();
    }

    public Examination findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Examination", "id", id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
