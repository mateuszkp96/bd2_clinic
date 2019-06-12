package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AppointmentDateDTO {
    private Long id;
    private String date;
    private String time;
    private String doctorName;
}
