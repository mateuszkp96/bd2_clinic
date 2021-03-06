package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.Patient;
import com.mkopec.clinic.domain.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {
    PatientCard findByDoctorAndPatient(Doctor doctor, Patient patient);

    @Query("SELECT pc FROM PatientCard pc WHERE pc.patient.id = ?2 AND pc.doctor.id = ?1")
    PatientCard findByDoctorIDAndPatientID(Long doctorID, Long patientID);
}
