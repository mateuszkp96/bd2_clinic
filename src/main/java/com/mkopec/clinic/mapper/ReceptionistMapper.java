package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Receptionist;
import com.mkopec.clinic.dtos.ShortEmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReceptionistMapper {

    public abstract ShortEmployeeDTO toShortEmployeeDTO(Receptionist receptionist);

    public abstract List<ShortEmployeeDTO> toShortEmployeeDTOs(List<Receptionist> receptionistList);
}
