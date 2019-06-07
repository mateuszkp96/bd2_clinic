package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AppointmentPostDTO {
    private Long id;
    private Integer dateDay;
    private Integer dateMonth;
    private Integer dateYear;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;
    private Long patientID;
    private Long doctorID;
}
