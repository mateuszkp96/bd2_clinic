package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, Long> {
    List<Referral> findAllByAppointment(Appointment appointment);
}
