package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.dtos.ShiftDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ShiftMapper {

    @Autowired
    protected ShiftPartMapper shiftPartMapper;

    @Mappings({
            @Mapping(target = "officeNumber", source = "shift.surgery.number"),
            @Mapping(target = "parts", expression = "java(shiftPartMapper.toShiftPartDTOs(shift.getShiftParts()))")
    })
    public abstract ShiftDTO toShiftDTO(Shift shift);

    public abstract List<ShiftDTO> toShiftDTOs(List<Shift> shifts);
}