package com.mkopec.clinic.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DoctorPostSpecializationDTO {
    private Long doctorID;
    private List<Long> specializations;
}
