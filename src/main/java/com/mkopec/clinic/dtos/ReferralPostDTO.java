package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class ReferralPostDTO {
    private Long id;
    private Long appointmentID;
    private ScopeOfExaminationDTO scope;
}
