package ru.proba.writings.DTO.city;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CityAdditionDTO {
    @NotBlank(message = "Впишите название города")
    private String name;
    @NotBlank(message = "Выберите часовой пояс")
    private String timezone;
}
