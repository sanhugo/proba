package ru.proba.writings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.writings.model.City;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByActive(Boolean active);
    Optional<City> findByNameAndTimezone(String name, String timezone);
}
