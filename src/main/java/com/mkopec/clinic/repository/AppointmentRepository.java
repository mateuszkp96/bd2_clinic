package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.domain.ShiftPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("select ap.shiftPart from Appointment ap where ap.date = ?1 and ap.shift = ?2")
    List<ShiftPart> findByDateAndShift(java.util.Calendar date, Shift shift);
}
