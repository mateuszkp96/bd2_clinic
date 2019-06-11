package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AppointmentExaminationPostDTO {
    private Long id;
    private Long appointmentID;
    private Long examinationID;
}
