package ru.proba.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Модель города с названием города и временной зоной, в которой город находится
 */
@Entity
@Getter
@Setter
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String timezone;

    @Column(nullable = false)
    private Boolean active;
}
