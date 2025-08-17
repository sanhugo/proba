package ru.proba.writings.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.proba.writings.DTO.building.BuildingAdditionDTO;
import ru.proba.writings.DTO.building.BuildingDTO;
import ru.proba.writings.converter.BuildingConverter;
import ru.proba.writings.model.Building;
import ru.proba.writings.model.City;
import ru.proba.writings.repositories.BuildingRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BuildingService {
    private final RoomService roomService;
    @PersistenceContext
    private EntityManager entityManager;
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository, RoomService roomService) {
        this.buildingRepository = buildingRepository;
        this.roomService = roomService;
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
    public void blockBuilding(Long buildingId) {
        Optional<Building>  building = buildingRepository.findById(buildingId);
        if (building.isPresent()){
            Long activeRooms = roomService.countActiveRoomsInBuilding(buildingId);
            if (activeRooms==0)
            {
                Building t = building.get();
                t.setActive(Boolean.FALSE);
                buildingRepository.save(t);
            }
        }
    }

    public void activateBuilding(Long buildingId) {
        Optional<Building>  building = buildingRepository.findById(buildingId);
        if (building.isPresent()){
            Building t = building.get();
            t.setActive(Boolean.TRUE);
            buildingRepository.save(t);
        }
    }

    public Long countActiveByCity(Integer cityId) {
        return buildingRepository.countByCity_ActiveTrue(cityId);
    }
}
