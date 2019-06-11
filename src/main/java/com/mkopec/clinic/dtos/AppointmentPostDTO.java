package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AppointmentPostDTO {
    private Long id;
    private Integer dateDay;
    private Integer dateMonth;
    private Integer dateYear;
    private Long shiftPartID;
    private Long patientID;
    private Long doctorID;
}
