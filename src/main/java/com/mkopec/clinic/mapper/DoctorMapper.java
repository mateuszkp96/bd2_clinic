package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.DoctorSpecialization;
import com.mkopec.clinic.dtos.DoctorDTO;
import com.mkopec.clinic.dtos.DoctorPostDTO;
import com.mkopec.clinic.dtos.DoctorPostSpecializationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DoctorMapper {

    @Autowired
    protected DoctorSpecializationMapper doctorSpecializationMapper;

    @Mappings({
            @Mapping(target = "firstname", source = "firstname"),
            @Mapping(target = "specialization", expression = "java(doctorSpecializationMapper.toDoctorSpecializationDTOs(doctor.getSpecializations()))")
    })
    public abstract DoctorDTO toDoctorDTO(Doctor doctor);

    public abstract List<DoctorDTO> toDoctorDTOs(List<Doctor> doctorList);

    @Mapping(target = "specializations", expression = "java(getSpecializationIDs(doctor))")
    public abstract DoctorPostDTO toDoctorDTOs(Doctor doctor);

    protected List<Long> getSpecializationIDs(Doctor doctor) {
        List<Long> idlist = new ArrayList<>();
        for (DoctorSpecialization sp : doctor.getSpecializations()) {
            idlist.add(sp.getSpecializationID());
        }
        return idlist;
    }

    @Mappings({
            @Mapping(target = "doctorID", source = "doctor.id"),
            @Mapping(target = "specializations", expression = "java(getSpecializationIDs(doctor))")
    })
    public abstract DoctorPostSpecializationDTO toDoctorPostSpecializationDTO(Doctor doctor);
}
