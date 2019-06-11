package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.Referral;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.ReferralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferralService {
    private final ReferralRepository repository;

    public Referral findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ScopeOfExamination", "id", id));
    }

    public List<Referral> findAll() {
        return repository.findAll();
    }

    public Referral save(Referral part) {
        return repository.save(part);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Referral> findByAppointment(Appointment appointment) {
        return repository.findAllByAppointment(appointment);
    }
}
