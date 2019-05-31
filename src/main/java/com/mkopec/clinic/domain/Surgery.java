package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Gabinety")
public class Surgery {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "numer_gabinetu")
    private String number;

    @ManyToOne
    @JoinColumn(name = "Przychodnie_id")
    private Clinic clinic;
}
