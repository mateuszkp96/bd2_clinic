package com.mkopec.clinic.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Badania")
public class Examination {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "cena")
    private Long price;

    @Column(name = "czy_wymaga_skierowania", columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean referralNeeded;
}
