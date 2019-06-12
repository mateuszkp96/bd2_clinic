package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.dtos.FullShiftPostDTO;
import com.mkopec.clinic.dtos.ShiftDTO;
import com.mkopec.clinic.dtos.ShiftPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ShiftMapper {

    @Autowired
    protected ShiftPartMapper shiftPartMapper;

    @Autowired
    protected SurgeryMapper surgeryMapper;

    @Mappings({
            @Mapping(target = "officeNumber", source = "shift.surgery.number"),
            @Mapping(target = "parts", expression = "java(shiftPartMapper.toShiftPartDTOs(shift.getShiftParts()))")
    })
    public abstract ShiftDTO toShiftDTO(Shift shift);

    public abstract List<ShiftDTO> toShiftDTOs(List<Shift> shifts);

    public abstract Shift toShift(ShiftPostDTO shiftPostDTO);
    
    @Mapping(target = "surgeryID", expression = "java(shift.getSurgery().getId())")
    public abstract ShiftPostDTO toShiftPostDTO(Shift shift);

    @Mappings({
            @Mapping(target = "surgery.id", source = "postDTO.doctorsOfficeID"),
            @Mapping(target = "doctor.id", source = "postDTO.doctorsID"),
            @Mapping(target = "dayOfWeek", expression = "java(Integer.valueOf(postDTO.getDay()))")
    })
    public abstract Shift toShift(FullShiftPostDTO postDTO);
}
