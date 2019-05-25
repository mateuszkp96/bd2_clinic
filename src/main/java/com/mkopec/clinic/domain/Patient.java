package com.mkopec.clinic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Pacjenci")
public class Patient {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "imię")
    private String firstname;

    @Column(name = "telefon")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Adresy_id")
    private Address address;
}
