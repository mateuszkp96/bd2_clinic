package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class DoctorAppointmentDTO {
    private Long id;
    private String patientFirstname;
    private String patientSurname;
    private String time;
}
