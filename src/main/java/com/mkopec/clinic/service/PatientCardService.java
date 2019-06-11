package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.Patient;
import com.mkopec.clinic.domain.PatientCard;
import com.mkopec.clinic.repository.PatientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatientCardService {
    private final PatientCardRepository repository;

    public PatientCard findByDoctorAndPatient(Doctor doctor, Patient patient) {
        return repository.findByDoctorAndPatient(doctor, patient);
    }

    public PatientCard save(PatientCard patientCard) {
        return repository.save(patientCard);
    }
}
