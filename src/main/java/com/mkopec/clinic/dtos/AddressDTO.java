package com.mkopec.clinic.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String postCode;

    private String city;

    private String street;

    private String houseNumber;
}
