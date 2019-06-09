package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Specialization;
import com.mkopec.clinic.dtos.SpecializationDTO;
import com.mkopec.clinic.dtos.SpecializationPostDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SpecializationMapper {

    public abstract SpecializationPostDTO toSpecializationPostDTO(Specialization specialization);

    public abstract SpecializationDTO toSpecializationDTO(Specialization specialization);

    public abstract List<SpecializationDTO> toSpecializationDTOs(List<Specialization> specializations);

    public abstract Specialization toSpecialization(SpecializationPostDTO specializationPostDTO);
}