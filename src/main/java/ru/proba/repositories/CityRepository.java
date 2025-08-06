package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
