package com.mkopec.clinic.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ShiftDTO {
    private Integer id;
    private String officeNumber;
    private List<ShiftPartDTO> parts;
}
