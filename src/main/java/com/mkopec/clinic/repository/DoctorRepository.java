package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT doc.id FROM Doctor doc, DoctorSpecialization sp WHERE sp.specializationID = ?1 AND sp IN (doc.specializations)")
    List<Long> findBySpecializationID(Long id);
}
