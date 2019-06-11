package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Examination;
import com.mkopec.clinic.dtos.ExaminationDTO;
import com.mkopec.clinic.dtos.ExaminationPostDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExaminationMapper {

    public abstract Examination toExamination(ExaminationPostDTO postDTO);

    public abstract ExaminationPostDTO toExaminationPostDTO(Examination examination);

    public abstract ExaminationDTO toExaminationDTO(Examination examination);

    public abstract List<ExaminationDTO> toExaminationDTOs(List<Examination> examinations);
}
