package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.domain.ShiftPart;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.projections.AppointmentDate;
import com.mkopec.clinic.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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

    public Appointment findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AppointmentService", "id", id));
    }

    public List<Appointment> findByDateAndDoctorID(Calendar calendar, Long doctorId) {
        return repository.findByDateAndDoctorID(calendar, doctorId);
    }

    public List<AppointmentDate> findAppointmentDates(Calendar from, Calendar to, List<Long> doctorIDs) {
        return repository.findMyResult(from, to, doctorIDs);
    }
}
