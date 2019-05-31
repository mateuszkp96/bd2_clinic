package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repository;

    public Doctor findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }
}
