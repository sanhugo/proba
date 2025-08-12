package ru.proba.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.proba.enums.ExamSubject;

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

    @ManyToOne
    @JoinColumn(nullable = false,name = "users_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamSubject subject;

    @ManyToOne
    @JoinColumn(nullable = false, name = "probes_id")
    private Probe probe;

    @Column(nullable = false)
    private Boolean isPayed;
}