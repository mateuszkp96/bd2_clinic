package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.DoctorSpecialization;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.DoctorSpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorSpecializationService {
    private final DoctorSpecializationRepository repository;

    public DoctorSpecialization findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Specialization", "id", id));
    }

    public List<DoctorSpecialization> findAllByIDs(List<DoctorSpecialization> doctorSpecializationIDs) {
        return repository.saveAll(doctorSpecializationIDs);
    }

    public List<DoctorSpecialization> getAll() {
        return repository.findAll();
    }

    public DoctorSpecialization save(DoctorSpecialization employee) {
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<DoctorSpecialization> saveAll(List<DoctorSpecialization> doctorSpecializations) {
        return repository.saveAll(doctorSpecializations);
    }

    public DoctorSpecialization findByDoctorAndSpecializationID(Doctor doctor, Long id) {
        return repository.findByDoctorAndSpecializationID(doctor, id);
    }
}
