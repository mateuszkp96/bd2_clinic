package com.mkopec.clinic.repository;

import com.mkopec.clinic.domain.ScopeOfExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScopeOfExaminationRepository extends JpaRepository<ScopeOfExamination, Long> {

}
