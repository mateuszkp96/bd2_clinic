package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String postCode;
    private String city;
    private String street;
    private String houseNumber;
}
