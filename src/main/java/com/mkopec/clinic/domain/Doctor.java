package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name = "Lekarze")
public class Doctor {

    @Id
    @Column(name = "Pracownicy_id")
    private Long id;

    @Column(name = "Pracownicy_imię")
    private String name;

    @Column(name = "Pracownicy_nazwisko")
    private String surname;

    @OneToMany(cascade = ALL, mappedBy = "doctor", fetch = LAZY)
    private List<DoctorSpecialization> specializations;
}
