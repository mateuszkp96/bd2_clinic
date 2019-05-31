package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class ShortClinicDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private AddressDTO address;
}
