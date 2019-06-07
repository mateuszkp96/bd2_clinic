package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.ShiftPart;
import com.mkopec.clinic.dtos.ShiftPartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ShiftPartMapper {

    @Mappings({
            @Mapping(target = "startHour", expression = "java(shiftPart.getStartTime().getHour())"),
            @Mapping(target = "startMinute", expression = "java(shiftPart.getStartTime().getMinute())"),
            @Mapping(target = "endHour", expression = "java(shiftPart.getStartTime().getHour())"),
            @Mapping(target = "endMinute", expression = "java(shiftPart.getStartTime().getMinute())")
    })
    public abstract ShiftPartDTO toShiftPartDTO(ShiftPart shiftPart);

    public abstract List<ShiftPartDTO> toShiftPartDTOs(List<ShiftPart> shiftParts);
}
