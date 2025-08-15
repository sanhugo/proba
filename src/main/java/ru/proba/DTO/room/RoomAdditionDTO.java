package ru.proba.DTO.room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomAdditionDTO {
    @NotNull
    private Long building_id;
    @NotNull
    private Integer capacity;
    @NotBlank
    private String num;

}
