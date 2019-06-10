package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.DoctorSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, Long> {
    DoctorSpecialization findByDoctorAndSpecializationID(Doctor doctor, Long id);
}
