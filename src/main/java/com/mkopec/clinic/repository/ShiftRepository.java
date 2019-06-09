package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findByDoctor(Doctor doctor);
    List<Shift> findByDoctorAndDayOfWeek(Doctor doctor, Integer dayOfWeek);
}
