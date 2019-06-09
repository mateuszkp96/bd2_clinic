package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@Table(name = "Sloty")
public class Part {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Basic
    @Column(name = "start")
    private java.time.LocalTime startTime;

    @Basic
    @Column(name = "koniec")
    private java.time.LocalTime endTime;
}
