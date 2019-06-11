package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.domain.ShiftPart;
import com.mkopec.clinic.dtos.AppointmentDTO;
import com.mkopec.clinic.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository repository;

    public List<ShiftPart> findByDateAndShift(java.util.Calendar date, Shift shift) {
        return repository.findByDateAndShift(date, shift);
    }

    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    public List<Appointment> findAll() {
        return repository.findAll();
    }
}
