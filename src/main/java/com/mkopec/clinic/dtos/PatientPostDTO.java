package com.mkopec.clinic.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientPostDTO {

    private String firstname;

    private String surname;

    private String phoneNumber;

    private String identityNumber;

    private AddressPostDTO address;
}
