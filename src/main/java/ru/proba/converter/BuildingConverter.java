package ru.proba.converter;

import ru.proba.DTO.building.BuildingDTO;
import ru.proba.model.Building;

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
