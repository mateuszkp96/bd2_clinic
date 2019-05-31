package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Clinic;
import com.mkopec.clinic.dtos.ClinicDTO;
import com.mkopec.clinic.dtos.ShortClinicDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ClinicMapper {

    @Autowired
    protected AddressMapper addressMapper;

    @Autowired
    protected EmployeeMapper employeeMapper;

    @Mappings({
            @Mapping(target = "address", expression = "java(addressMapper.toAddressDTO(clinic.getAddress()))"),
            @Mapping(target = "employees", expression = "java(employeeMapper.toEmployeeDTOs(clinic.getEmployees()))")
    })
    public abstract ClinicDTO toClinicDTO(Clinic clinic);

    public abstract List<ClinicDTO> toClinicDTOs(List<Clinic> clinics);

    @Mapping(target = "address", expression = "java(addressMapper.toAddressDTO(clinic.getAddress()))")
    public abstract ShortClinicDTO toShortClinicDTO(Clinic clinic);

    public abstract List<ShortClinicDTO> toShortClinicDTOs(List<Clinic> clinics);
}
