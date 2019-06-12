package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.dtos.AppointmentDTO;
import com.mkopec.clinic.dtos.AppointmentPostDTO;
import com.mkopec.clinic.dtos.DoctorAppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {

    @Mapping(target = "date", expression = "java(getDateFromDTO(postDTO))")
    public abstract Appointment toAppointment(AppointmentPostDTO postDTO);

    @Mappings({
            @Mapping(target = "date", expression = "java(getTimeStringCalendar(appointment))"),
            @Mapping(target = "shiftPartID", source = "appointment.shiftPart.id"),
            @Mapping(target = "patientID", source = "appointment.patientCard.patient.id"),
            @Mapping(target = "doctorID", source = "appointment.patientCard.doctor.id")
    })
    public abstract AppointmentPostDTO toAppointmentPostDTO(Appointment appointment);

    @Mapping(target = "patientCardID", source = "appointment.patientCard.id")
    @Mapping(target = "shiftPartID", source = "appointment.shiftPart.id")
    public abstract AppointmentDTO toAppointmentDTO(Appointment appointment);

    public abstract List<AppointmentDTO> toAppointmentDTOs(List<Appointment> appointmentList);

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

    protected Calendar getDateFromDTO(AppointmentPostDTO dto) {
        Calendar c = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = format.parse(dto.getDate());
            c.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c;
    }

    protected String getTimeStringCalendar(Appointment appointment) {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date = appointment.getDate().getTime();
        return format.format(date);
    }


}
