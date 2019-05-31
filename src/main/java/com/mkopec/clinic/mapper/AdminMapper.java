package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Admin;
import com.mkopec.clinic.dtos.ShortEmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AdminMapper {

    public abstract ShortEmployeeDTO toShortEmployeeDTO(Admin admin);

    public abstract List<ShortEmployeeDTO> toShortEmployeeDTOs(List<Admin> adminList);
}
