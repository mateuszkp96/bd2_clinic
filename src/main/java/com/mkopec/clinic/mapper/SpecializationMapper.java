package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.DoctorSpecialization;
import com.mkopec.clinic.domain.Specialization;
import com.mkopec.clinic.dtos.SpecializationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SpecializationMapper {

    @Mappings({
            @Mapping(target = "id", source = "specializationID"),
            @Mapping(target = "name", source = "specializationName")
    })
    public abstract SpecializationDTO toSpecializationDTO(DoctorSpecialization doctorSpecialization);

    public abstract List<SpecializationDTO> toDoctorSpecializationDTOs(List<DoctorSpecialization> doctorSpecializations);

    public abstract SpecializationDTO toSpecializationDTO(Specialization specialization);

    public abstract List<SpecializationDTO> toSpecializationDTOs(List<Specialization> specializations);
}