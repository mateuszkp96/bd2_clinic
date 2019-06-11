package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.ScopeOfExamination;
import com.mkopec.clinic.dtos.ScopeOfExaminationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ScopeOfExaminationMapper {

    public abstract ScopeOfExamination toScopeOfExamination(ScopeOfExaminationDTO dto);

    public abstract ScopeOfExaminationDTO toScopeOfExaminationDTO(ScopeOfExamination scope);

    public abstract List<ScopeOfExaminationDTO> toScopeOfExaminationDTOs(List<ScopeOfExamination> scopeOfExaminationList);
}
