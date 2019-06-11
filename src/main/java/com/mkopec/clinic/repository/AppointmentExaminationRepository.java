package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.AppointmentExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentExaminationRepository extends JpaRepository<AppointmentExamination, Long> {
    List<AppointmentExamination> findByAppointment(Appointment appointment);
}
