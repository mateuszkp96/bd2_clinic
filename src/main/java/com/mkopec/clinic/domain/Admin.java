package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Administratorzy")
public class Admin {
    @Id
    @Column(name = "Pracownicy_id")
    private Long id;

    @Column(name = "Pracownicy_nazwisko")
    private String surname;

    @Column(name = "Pracownicy_imię")
    private String firstname;

    @OneToOne
    @JoinColumn(name = "Pracownicy_id")
    private Employee employee;
}
