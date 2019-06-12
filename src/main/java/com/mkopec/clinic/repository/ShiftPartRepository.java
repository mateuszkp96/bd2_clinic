package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.ShiftPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftPartRepository extends JpaRepository<ShiftPart, Long> {
    @Query("SELECT sp FROM ShiftPart sp WHERE sp.shift.id = ?1")
    List<ShiftPart> findAllByShiftID(Long shiftID);
}
