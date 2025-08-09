package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.DTO.building.BuildingDTO;
import ru.proba.model.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    void save(BuildingDTO buildingDTO);
}
