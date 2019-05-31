package com.mkopec.clinic.dtos;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String surname;
    private String role;
}
