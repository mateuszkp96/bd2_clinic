package com.mkopec.clinic.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO {
    private Long id;
    private String firstname;
    private String surname;
    private List<SpecializationDTO> specialization;
}
