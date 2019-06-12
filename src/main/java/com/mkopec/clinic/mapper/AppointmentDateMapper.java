package com.mkopec.clinic.mapper;

import com.mkopec.clinic.dtos.AppointmentDateDTO;
import com.mkopec.clinic.projections.AppointmentDate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AppointmentDateMapper {

    @Mappings({
            @Mapping(target = "id", expression = "java(date.getID())"),
            @Mapping(target = "date", expression = "java(date.getSelectedDate())"),
            @Mapping(target = "time", expression = "java(getTimeFromAppointmentDate(date))"),
            @Mapping(target = "doctorName", expression = "java(getNameFromAppointmentDate(date))")
    })
    public abstract AppointmentDateDTO toAppointmentDateDTO(AppointmentDate date);

    public abstract List<AppointmentDateDTO> toAppointmentDateDTOs(List<AppointmentDate> dateList);

    protected String getTimeFromAppointmentDate(AppointmentDate date) {
        return date.getPartStart() + " - " + date.getPartEnd();
    }

    protected String getNameFromAppointmentDate(AppointmentDate date){
        return date.getSurname() + " " + date.getFirstname();
    }
}
