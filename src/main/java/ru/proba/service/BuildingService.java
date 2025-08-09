package ru.proba.service;

import org.springframework.stereotype.Service;
import ru.proba.DTO.building.BuildingDTO;
import ru.proba.model.Building;
import ru.proba.repositories.BuildingRepository;

import java.util.List;

@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public void saveBuilding(BuildingDTO  buildingDTO) {
        buildingRepository.save(buildingDTO);
    }
}
