package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class PartPostDTO {
    private Long id;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;
}
