package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Specialization;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecializationService {

    private final SpecializationRepository repository;

    public Specialization findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Specialization", "id", id));
    }

    public List<Specialization> findAllByID(List<Long> specializationIDs) {
        return repository.findAllById(specializationIDs);
    }

    public List<Specialization> getAll() {
        return repository.findAll();
    }

    public Specialization save(Specialization employee) {
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
