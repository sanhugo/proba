package ru.proba.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность для постановки даты и времени пробника
 */
@Entity
@Getter
@Setter
public class Probe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @FutureOrPresent
    @Column(nullable = false)
    private LocalDateTime date;

    private LocalTime startTime;

    @OneToMany
    private List<Record> records =  new ArrayList<Record>();
}
