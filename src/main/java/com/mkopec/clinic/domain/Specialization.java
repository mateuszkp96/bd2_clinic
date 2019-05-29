package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@Table(name = "Specjalności")
public class Specialization {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nazwa")
    private String name;
}
