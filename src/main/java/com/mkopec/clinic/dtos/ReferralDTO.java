package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class ReferralDTO {
    private Long id;
    private Long appointmentID;
    private ScopeOfExaminationDTO scope;
}
