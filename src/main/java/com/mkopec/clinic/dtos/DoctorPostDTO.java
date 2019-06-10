package com.mkopec.clinic.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DoctorPostDTO {
    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String surname;
    private List<Long> specializations;
}
