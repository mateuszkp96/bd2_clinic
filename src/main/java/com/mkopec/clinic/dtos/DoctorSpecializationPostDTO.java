package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class DoctorSpecializationPostDTO {
    private Long id;
    private Long specializationID;
    private Long doctorID;
}
