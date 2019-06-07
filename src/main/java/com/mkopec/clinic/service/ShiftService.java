package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.Shift;
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
}
