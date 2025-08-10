package ru.proba.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import ru.proba.DTO.building.BuildingAdditionDTO;
import ru.proba.DTO.building.BuildingDTO;
import ru.proba.converter.BuildingConverter;
import ru.proba.model.Building;
import ru.proba.model.City;
import ru.proba.repositories.BuildingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {
    @PersistenceContext
    private EntityManager entityManager;
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<BuildingDTO> findAll() {
        return BuildingConverter.convertToBuildingDTO(buildingRepository.findByCityActive(Boolean.TRUE));
    }

    public void save(BuildingAdditionDTO buildingDTO) {
        Building building = new Building();
        City cityRef = entityManager.getReference(City.class, buildingDTO.getCity_id());
        building.setCity(cityRef);
        building.setActive(Boolean.TRUE);
        building.setAddress(buildingDTO.getAddress());
        building.setDescription(buildingDTO.getDescription());
        buildingRepository.save(building);
    }

    public List<BuildingDTO> findByCity(Integer id) {
        List<Building> buildings = buildingRepository.findByCityId(id);
        return BuildingConverter.convertToBuildingDTO(buildings);
    }
    public void blockBuilding(Integer buildingId) {
        Optional<Building>  building = buildingRepository.findById(buildingId);
        if (building.isPresent()){
            Building t = building.get();
            t.setActive(Boolean.FALSE);
            buildingRepository.save(t);
        }
    }

    public void activateBuilding(Integer buildingId) {
        Optional<Building>  building = buildingRepository.findById(buildingId);
        if (building.isPresent()){
            Building t = building.get();
            t.setActive(Boolean.TRUE);
            buildingRepository.save(t);
        }
    }
}
