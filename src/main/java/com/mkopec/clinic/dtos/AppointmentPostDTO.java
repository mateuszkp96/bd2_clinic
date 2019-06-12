package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AppointmentPostDTO {
    private Long id;
    private String date;
    private Long shiftPartID;
    private Long patientID;
    private Long doctorID;
}
