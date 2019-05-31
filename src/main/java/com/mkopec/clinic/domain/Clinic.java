package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Przychodnie")
public class Clinic {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "telefon")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "Adresy_id")
    private Address address;

    @ManyToMany(fetch = LAZY, cascade = ALL)
    @JoinTable(
            name = "Przychodnie_Pracownicy",
            joinColumns = @JoinColumn(name = "Przychodnie_id"),
            inverseJoinColumns = @JoinColumn(name = "Pracownicy_id")
    )
    private List<Employee> employees;
}
