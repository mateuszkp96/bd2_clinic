package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Long id;
    private Long patientCardID;
    private Long shiftPartID;
}
