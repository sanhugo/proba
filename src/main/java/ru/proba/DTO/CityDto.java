package ru.proba.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

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
    @NotBlank(message = "Выберите часовой пояс")
    private String timezone;
}