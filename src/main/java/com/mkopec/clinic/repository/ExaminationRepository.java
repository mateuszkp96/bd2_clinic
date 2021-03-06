package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
