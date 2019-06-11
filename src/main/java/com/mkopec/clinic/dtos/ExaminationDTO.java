package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class ExaminationDTO {
    private Long id;
    private String name;
    private Long price;
    private Boolean referralNeeded;
}
