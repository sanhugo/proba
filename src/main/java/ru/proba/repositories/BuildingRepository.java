package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.model.Building;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findByCityId(Integer id);
    List<Building> findByCityActive(Boolean cityActive);
}
