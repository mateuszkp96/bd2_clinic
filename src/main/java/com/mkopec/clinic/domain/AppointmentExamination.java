package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Wizyty_Badania")
public class AppointmentExamination {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Wizyty_id")
    private Appointment appointment;

    @Column(name = "Badania_nazwa")
    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Badania_id")
    private Examination examination;
}
