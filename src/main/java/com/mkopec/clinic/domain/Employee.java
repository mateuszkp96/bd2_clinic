package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Pracownicy")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "hasło")
    private String password;

    @Column(name = "imię")
    private String firstname;

    @Column(name = "nazwisko")
    private String surname;

    @ManyToMany(mappedBy = "employees")
    private List<Clinic> clinics;

    @OneToOne(mappedBy = "employee", orphanRemoval = true)
    private Admin admin;
}
