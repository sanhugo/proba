package ru.proba.writings.DTO.building;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class BuildingDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String address;
    @NotBlank
    private String description;
    @NotNull
    private Boolean active;
}
