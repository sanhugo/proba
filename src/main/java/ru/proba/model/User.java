package ru.proba.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.proba.enums.Role;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column
    private Long tg_id;

    @Enumerated(EnumType.STRING)
    private ArrayList<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;
}
