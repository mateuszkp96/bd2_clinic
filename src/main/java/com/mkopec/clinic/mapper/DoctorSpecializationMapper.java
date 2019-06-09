package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.DoctorSpecialization;
import com.mkopec.clinic.dtos.DoctorSpecializationDTO;
import com.mkopec.clinic.dtos.DoctorSpecializationPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DoctorSpecializationMapper {

    @Mapping(target = "doctorID", expression = "java(doctorSpecialization.getDoctor().getId())")
    public abstract DoctorSpecializationPostDTO toDoctorSpecializationPostDTO(DoctorSpecialization doctorSpecialization);

    @Mappings({
            @Mapping(target = "name", source = "doctorSpecialization.specializationName"),
            @Mapping(target = "doctorID", expression = "java(doctorSpecialization.getDoctor().getId())")
    })
    public abstract DoctorSpecializationDTO toDoctorSpecializationDTO(DoctorSpecialization doctorSpecialization);

    public abstract List<DoctorSpecializationDTO> toDoctorSpecializationDTOs(List<DoctorSpecialization> doctorSpecializations);

    public abstract DoctorSpecialization toDoctorSpecialization(DoctorSpecializationPostDTO doctorSpecializationPostDTO);
}
