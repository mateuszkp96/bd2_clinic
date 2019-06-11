package com.mkopec.clinic.dtos;


import lombok.Data;

@Data
public class ExaminationPostDTO {
    private Long id;
    private String name;
    private Long price;
    private Boolean referralNeeded;
}
