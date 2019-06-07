package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.dtos.AppointmentPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Calendar;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {

    @Mappings({
            @Mapping(target = "date", expression = "java(getDate(appointmentPostDTO))")
    })
    public abstract Appointment toAppointment(AppointmentPostDTO appointmentPostDTO);

    public abstract AppointmentPostDTO toAppointment(Appointment appointment);

    protected Calendar getDate(AppointmentPostDTO appointmentPostDTO) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, appointmentPostDTO.getDateYear());
        c.set(Calendar.MONTH, appointmentPostDTO.getDateMonth());
        c.set(Calendar.DAY_OF_MONTH, appointmentPostDTO.getDateDay());
        return c;
    }
}
