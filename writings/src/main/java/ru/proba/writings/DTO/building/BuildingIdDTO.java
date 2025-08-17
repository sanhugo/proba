package ru.proba.writings.DTO.building;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuildingIdDTO {
    @NotNull
    private Long buildingId;
}
