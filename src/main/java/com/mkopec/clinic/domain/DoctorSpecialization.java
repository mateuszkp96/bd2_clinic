package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Lekarze_Specjalności")
public class DoctorSpecialization {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "Specjalności_id")
    private Long specializationID;

    @Column(name = "Specjalności_nazwa")
    private String specializationName;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Lekarze_id")
    private Doctor doctor;
}
