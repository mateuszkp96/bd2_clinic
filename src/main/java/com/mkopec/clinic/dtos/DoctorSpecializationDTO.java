package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class DoctorSpecializationDTO {
    private Long id;
    private Long doctorID;
    private String name;
}
