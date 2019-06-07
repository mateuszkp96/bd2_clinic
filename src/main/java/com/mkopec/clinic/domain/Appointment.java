package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Wizyty")
public class Appointment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private java.util.Calendar date;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Dyżury_id")
    private Shift shift;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Dyżury_Sloty_id")
    private ShiftPart shiftPart;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Karty_Pacjenta_id")
    private PatientCard patientCard;
}
