package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.AppointmentExamination;
import com.mkopec.clinic.dtos.AppointmentExaminationDTO;
import com.mkopec.clinic.dtos.AppointmentExaminationPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AppointmentExaminationMapper {

    @Mappings({
            @Mapping(target = "appointmentID", source = "appointment.id"),
            @Mapping(target = "examinationID", source = "examination.id"),
    })
    public abstract AppointmentExaminationPostDTO toAppointmentExaminationPostDTO(AppointmentExamination examination);

    @Mappings({
            @Mapping(target = "appointment.id", source = "postDTO.appointmentID"),
            @Mapping(target = "examination.id", source = "postDTO.examinationID")
    })
    public abstract AppointmentExamination toAppoinmentExamination(AppointmentExaminationPostDTO postDTO);

    public abstract AppointmentExaminationDTO toAppointmentDTO(AppointmentExamination examination);

    public abstract List<AppointmentExaminationDTO> toAppointmentExaminationDTOs(List<AppointmentExamination> examinations);
}

