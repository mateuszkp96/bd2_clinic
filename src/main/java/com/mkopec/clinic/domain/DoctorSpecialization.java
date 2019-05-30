package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Lekarze_Specjalności")
public class DoctorSpecialization {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Lekarze_id")
    private Long doctorID;

    @Column(name = "Specjalności_id")
    private Long specializationID;

    @Column(name = "Specjalności_name")
    private String specializationName;
}
