package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Patient;
import com.mkopec.clinic.dtos.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PatientMapper {

    @Autowired
    protected AddressMapper addressMapper;

    @Mapping(target = "address", expression = "java(addressMapper.toAddressDTO(patient.getAddress()))")
    public abstract PatientDTO toPatientDTO(Patient patient);
}
