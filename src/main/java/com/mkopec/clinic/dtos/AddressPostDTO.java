package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class AddressPostDTO {
    private String postCode;
    private String city;
    private String street;
    private String houseNumber;
}
