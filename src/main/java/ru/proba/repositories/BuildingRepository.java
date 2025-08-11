package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.proba.model.Building;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findByCityId(Integer id);
    List<Building> findByCityActive(Boolean cityActive);

    Optional<Building> findById(Long id);

    @Query("select count(b) from Building b where b.active = true and b.city.id=:cityId")
    long countByCity_ActiveTrue(Integer cityId);
}
