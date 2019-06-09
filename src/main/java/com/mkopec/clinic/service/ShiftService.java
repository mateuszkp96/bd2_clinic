package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftService {
    private final ShiftRepository repository;

    public List<Shift> findDoctorShifts(Doctor doctor) {
        return repository.findByDoctor(doctor);
    }

    public List<Shift> findByDoctorAndDayOfWeek(Doctor doctor, Integer dayOfWeek) {
        return repository.findByDoctorAndDayOfWeek(doctor, dayOfWeek);
    }

    public Shift findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shift", "id", id));
    }

    public List<Shift> getAll() {
        return repository.findAll();
    }

    public Shift save(Shift shift) {
        return repository.save(shift);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
