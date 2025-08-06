package ru.proba.service;

import org.springframework.stereotype.Service;
import ru.proba.model.City;
import ru.proba.repositories.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void addCity(City city) {
        cityRepository.save(city);
    }

    public void deleteCity(Integer cityId) {
        cityRepository.deleteById(cityId);
    }
}
