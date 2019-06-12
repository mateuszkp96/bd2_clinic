package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class FullShiftPostDTO {
    private Long id;
    private String day;
    private String startTime;
    private String endTime;
    private Long doctorsOfficeID;
    private Long doctorsID;
}
