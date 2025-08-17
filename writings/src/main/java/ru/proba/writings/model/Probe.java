package ru.proba.writings.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.Setter;
import ru.proba.writings.enums.Condition;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Сущность для постановки даты и времени пробника, а также ограничений
 */
@Entity
@Getter
@Setter
@Table(name = "probes")
public class Probe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime startTime;

    @OneToMany
    private ArrayList<Record> records;

    @Column
    @Enumerated(EnumType.STRING)
    private Condition condition;
}
