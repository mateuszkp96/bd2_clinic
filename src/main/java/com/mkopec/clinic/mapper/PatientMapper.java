package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Patient;
import com.mkopec.clinic.dtos.PatientDTO;
import com.mkopec.clinic.dtos.ShortPatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PatientMapper {

    @Autowired
    protected AddressMapper addressMapper;

    @Mapping(target = "address", expression = "java(addressMapper.toAddressDTO(patient.getAddress()))")
    public abstract PatientDTO toPatientDTO(Patient patient);

    public abstract ShortPatientDTO toShortPatientDTO(Patient patient);

    public abstract List<ShortPatientDTO> toShortPatientDTOs(List<Patient> patients);
}
