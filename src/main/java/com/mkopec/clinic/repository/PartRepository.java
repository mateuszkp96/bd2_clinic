package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

//    @Query("SELECT p FROM Part p WHERE ?1 >= p.startTime AND ?2 <= p.endTime AND p.endTime.minus = p.startTime")
//    List<Part> findByStartTimeAndEndTimeAndQuant(LocalTime startTime, LocalTime endTime, Long quant);

        @Query(nativeQuery = true,
            value = "SELECT * FROM Sloty WHERE :startTime <= Sloty.start AND  Sloty.koniec <= :endTime AND TIMEDIFF(Sloty.koniec, Sloty.start) = :quant")
    List<Part> findByStartTimeAndEndTimeAndQuant(@Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime, @Param("quant") String quant);

}
