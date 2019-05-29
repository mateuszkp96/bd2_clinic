package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
