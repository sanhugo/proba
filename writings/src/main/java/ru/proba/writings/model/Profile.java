package ru.proba.writings.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String secondName;

    @Column(nullable = false)
    private String surname;

    @Column(nullable=false)
    private Long user_id;
}
