package com.mkopec.clinic.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ClinicDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private AddressDTO address;
    private List<EmployeeDTO> employees;
}
