package ru.proba.DTO.city;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * DTO for {@link ru.proba.model.City}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CityDto{
    @NotBlank
    private Integer id;
    @NotBlank(message = "Впишите название города")
    private String name;
}