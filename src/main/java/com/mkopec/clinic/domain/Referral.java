package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Skierowania_wystawione")
public class Referral {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Wizyty_id")
    private Appointment appointment;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Zakresy_Badań_id")
    private ScopeOfExamination scope;

    @Column(name = "Zakresy_Badań_nazwa")
    private String name;
}
