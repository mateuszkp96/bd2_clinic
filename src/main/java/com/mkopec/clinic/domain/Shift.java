package com.mkopec.clinic.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name = "Dyżury")
public class Shift {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dzień_tygodnia")
    private Integer dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "Gabinety_id")
    private Surgery surgery;

    @ManyToOne
    @JoinColumn(name = "Lekarze_Pracownicy_id")
    private Doctor doctor;

    @OneToMany(cascade = ALL, mappedBy = "shift", fetch = LAZY)
    private List<ShiftPart> shiftParts;
}
