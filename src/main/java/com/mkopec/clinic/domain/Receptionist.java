package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Recepcjoniści")
public class Receptionist {

    @Id
    @Column(name = "Pracownicy_id")
    private Long id;

    @Column(name = "Pracownicy_nazwisko")
    private String firstname;

    @Column(name = "Pracownicy_imię")
    private String surname;

    @OneToOne
    @JoinColumn(name = "Pracownicy_id")
    private Employee employee;
}
