package ru.proba.writings.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.proba.writings.enums.ExamSubject;

/**
 * Сущность записи на пробник
 */
@Entity
@Getter
@Setter
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false,name = "profiles_id")
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private ExamSubject subject;

    @ManyToOne
    @JoinColumn(nullable = false, name = "probes_id")
    private Probe probe;

    @Column(nullable = false)
    private Boolean isPayed;
}