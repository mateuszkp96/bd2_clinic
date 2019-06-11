package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.AppointmentExamination;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.AppointmentExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentExaminationService {
    private final AppointmentExaminationRepository repository;

    public AppointmentExamination findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Part", "id", id));
    }

    public List<AppointmentExamination> getAll() {
        return repository.findAll();
    }

    public AppointmentExamination save(AppointmentExamination part) {
        return repository.save(part);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<AppointmentExamination> findByAppointment(Appointment appointment) {
        return repository.findByAppointment(appointment);
    }
}
