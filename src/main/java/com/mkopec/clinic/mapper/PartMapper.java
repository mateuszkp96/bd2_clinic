package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Part;
import com.mkopec.clinic.dtos.PartDTO;
import com.mkopec.clinic.dtos.PartPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalTime;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PartMapper {

    @Mappings({
            @Mapping(target = "startHour", expression = "java(part.getStartTime().getHour())"),
            @Mapping(target = "startMinute", expression = "java(part.getStartTime().getMinute())"),
            @Mapping(target = "endHour", expression = "java(part.getEndTime().getHour())"),
            @Mapping(target = "endMinute", expression = "java(part.getEndTime().getMinute())")
    })
    public abstract PartPostDTO toPartPostDTO(Part part);

    @Mappings({
            @Mapping(target = "startTime", expression = "java(getStartTime(partPostDTO))"),
            @Mapping(target = "endTime", expression = "java(getEndTime(partPostDTO))")
    })
    public abstract Part toPart(PartPostDTO partPostDTO);

    @Mapping(target = "time", expression = "java(getTimeString(part))")
    public abstract PartDTO toPartDTO(Part part);

    public abstract List<PartDTO> toPartDTOs(List<Part> partList);

    protected java.time.LocalTime getStartTime(PartPostDTO partPostDTO) {
        return LocalTime.of(partPostDTO.getStartHour(), partPostDTO.getStartMinute());
    }

    protected java.time.LocalTime getEndTime(PartPostDTO partPostDTO) {
        return LocalTime.of(partPostDTO.getEndHour(), partPostDTO.getEndMinute());
    }

    protected String getTimeString(Part part) {
        return part.getStartTime().toString() + "-" + part.getEndTime().toString();
    }
}
