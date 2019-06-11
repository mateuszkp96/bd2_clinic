package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.domain.ShiftPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftPartRepository extends JpaRepository<ShiftPart, Long> {
    List<ShiftPart> findByShift(Shift shift);
}
