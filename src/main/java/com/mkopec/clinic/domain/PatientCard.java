package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "karty_Pacjenta")
public class PatientCard {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "Pacjenci_nazwisko")
    private String firstname;

    @Column(name = "Pacjenci_imię")
    private String surname;

    @Column(name = "Pacjenci_pesel")
    private String pesel;

    @Column(name = "Data_utworzenia")
    private java.util.Calendar createDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Lekarze_id")
    private Doctor doctor;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Pacjenci_id")
    private Patient patient;

    @OneToMany(fetch = LAZY)
    private List<Appointment> appointments;
}
