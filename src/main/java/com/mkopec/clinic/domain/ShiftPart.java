package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Dyżury_Sloty")
public class ShiftPart {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Dyżury_id")
    private Shift shift;

    @Column(name = "Sloty_id")
    private Long partID;

    @Basic
    @Column(name = "Sloty_start")
    private java.time.LocalTime startTime;

    @Basic
    @Column(name = "Sloty_koniec")
    private java.time.LocalTime endTime;
}
