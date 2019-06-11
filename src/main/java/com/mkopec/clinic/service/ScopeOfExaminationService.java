package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.ScopeOfExamination;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.ScopeOfExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScopeOfExaminationService {
    private final ScopeOfExaminationRepository repository;

    public ScopeOfExamination findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ScopeOfExamination", "id", id));
    }

    public List<ScopeOfExamination> findAll() {
        return repository.findAll();
    }

    public ScopeOfExamination save(ScopeOfExamination part) {
        return repository.save(part);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
