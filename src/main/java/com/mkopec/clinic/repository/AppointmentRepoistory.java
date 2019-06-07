package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepoistory extends JpaRepository<Appointment, Long> {

}
