package ru.proba.writings.DTO.city;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import ru.proba.writings.model.City;

/**
 * DTO for {@link City}
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