package com.mkopec.clinic.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {

    private Long id;

    private String firstname;

    private String surname;

    private String phoneNumber;

    private AddressDTO address;
}
