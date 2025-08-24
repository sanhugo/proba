package ru.proba.authentication.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {
    @NotNull
    private String login;
    @NotNull
    private String password;
}
