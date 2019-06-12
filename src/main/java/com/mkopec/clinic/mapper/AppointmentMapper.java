package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.dtos.AppointmentDTO;
import com.mkopec.clinic.dtos.AppointmentPostDTO;
import com.mkopec.clinic.dtos.DoctorAppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Calendar;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {

    @Mappings({
            @Mapping(target = "date", expression = "java(getDate(appointmentPostDTO))")
    })
    public abstract Appointment toAppointment(AppointmentPostDTO appointmentPostDTO);

    public abstract AppointmentPostDTO toAppointment(Appointment appointment);

    @Mappings({
            @Mapping(target = "dateDay", expression = "java(getDay(appointment.getDate()))"),
            @Mapping(target = "dateMonth", expression = "java(getMonth(appointment.getDate()))"),
            @Mapping(target = "dateYear", expression = "java(getYear(appointment.getDate()))"),
            @Mapping(target = "shiftPartID", source = "appointment.shiftPart.id"),
            @Mapping(target = "patientID", source = "appointment.patientCard.patient.id"),
            @Mapping(target = "doctorID", source = "appointment.patientCard.doctor.id")
    })
    public abstract AppointmentPostDTO toAppointmentPostDTO(Appointment appointment);

    @Mapping(target = "patientCardID", source = "appointment.patientCard.id")
    @Mapping(target = "shiftPartID", source = "appointment.shiftPart.id")
    public abstract AppointmentDTO toAppointmentDTO(Appointment appointment);

    public abstract List<AppointmentDTO> toAppointmentDTOs(List<Appointment> appointmentList);


    protected Integer getYear(Calendar c) {
        return c.get(Calendar.YEAR);
    }

    protected Integer getMonth(Calendar c) {
        return c.get(Calendar.MONTH);
    }

    protected Integer getDay(Calendar c) {
        return c.get(Calendar.DAY_OF_MONTH);
    }

    protected Calendar getDate(AppointmentPostDTO appointmentPostDTO) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, appointmentPostDTO.getDateYear());
        c.set(Calendar.MONTH, appointmentPostDTO.getDateMonth());
        c.set(Calendar.DAY_OF_MONTH, appointmentPostDTO.getDateDay());
        return c;
    }


    @Mappings({
            @Mapping(target = "patientFirstname", source = "patientCard.firstname"),
            @Mapping(target = "patientSurname", source = "patientCard.surname"),
            @Mapping(target = "time", expression = "java(getTimeString(appointment))")
    })
    public abstract DoctorAppointmentDTO toDoctorAppointmentDTO(Appointment appointment);

    public abstract List<DoctorAppointmentDTO> toDoctorAppointmentDTOs(List<Appointment> appointments);

    protected String getTimeString(Appointment appointment) {
        return appointment.getShiftPart().getStartTime().toString() + "-" + appointment.getShiftPart().getEndTime().toString();
    }

}
