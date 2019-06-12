package com.mkopec.clinic.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AppointmentDetailsDTO {
    private Long id;
    private PatientDTO patient;
    private Long doctorID;
    private String date;
    private String time;
    private List<ExaminationDTO> examination;
    private ReferralDTO referral;
}
