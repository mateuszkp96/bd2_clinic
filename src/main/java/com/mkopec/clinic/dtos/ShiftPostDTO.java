package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class ShiftPostDTO {
    private Long id;
    private Integer dayOfWeek;
    private Long surgeryID;
}
