package com.mkopec.clinic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Adresy")
public class Address {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kod_pocztowy")
    private String postCode;

    @Column(name = "miasto")
    private String city;

    @Column(name = "ulica")
    private String street;

    @Column(name = "nr_budynku")
    private String houseNumber;
}
