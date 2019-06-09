package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.dtos.DoctorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DoctorMapper {

    @Autowired
    protected DoctorSpecializationMapper doctorSpecializationMapper;

    @Mappings({
            @Mapping(target = "firstname", source = "name"),
            @Mapping(target = "specialization", expression = "java(doctorSpecializationMapper.toDoctorSpecializationDTOs(doctor.getSpecializations()))")
    })
    public abstract DoctorDTO toDoctorDTO(Doctor doctor);

    public abstract List<DoctorDTO> toDoctorDTOs(List<Doctor> doctorList);
}
