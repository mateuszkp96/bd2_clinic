package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Admin;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository repository;

    public Admin findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
    }

    public List<Admin> getAll() {
        return repository.findAll();
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }
}
