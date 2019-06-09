package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Part;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepository repository;

    public Part findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Part", "id", id));
    }

    public List<Part> getAll() {
        return repository.findAll();
    }

    public Part save(Part part) {
        return repository.save(part);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
