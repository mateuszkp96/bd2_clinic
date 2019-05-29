package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String identityNumber;
    private AddressDTO address;
}
