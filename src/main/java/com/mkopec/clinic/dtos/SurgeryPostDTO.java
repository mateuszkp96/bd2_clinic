package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class SurgeryPostDTO {
    private Long id;
    private String number;
    private Long clinicID;
}
