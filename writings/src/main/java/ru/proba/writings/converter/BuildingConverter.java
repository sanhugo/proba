package ru.proba.writings.converter;

import ru.proba.writings.DTO.building.BuildingDTO;
import ru.proba.writings.model.Building;

import java.util.ArrayList;
import java.util.List;

public class BuildingConverter {
    public static List<BuildingDTO> convertToBuildingDTO(List<Building> buildings) {
        List<BuildingDTO> buildingDTOs = new ArrayList<>();
        for (Building building : buildings) {
            BuildingDTO buildingDTO = new BuildingDTO(building.getId(), building.getAddress(),building.getDescription(),building.getActive());
            buildingDTOs.add(buildingDTO);
        }
        return buildingDTOs;
    }
}
