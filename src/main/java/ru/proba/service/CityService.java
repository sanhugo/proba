package ru.proba.service;

import org.springframework.stereotype.Service;
import ru.proba.DTO.CityAdditionDTO;
import ru.proba.DTO.CityDto;
import ru.proba.converter.CityConverter;
import ru.proba.model.City;
import ru.proba.repositories.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void save(CityAdditionDTO city) {
        City cityEntity = new City();
        cityEntity.setName(city.getName());
        cityEntity.setTimezone(city.getTimezone());
        cityEntity.setActive(Boolean.TRUE);
        cityRepository.save(cityEntity);
    }

    public void blockCity(Integer cityId) {
        Optional<City> s = cityRepository.findById(cityId);
        if (s.isPresent()) {
            City city = s.get();
            city.setActive(Boolean.FALSE);
            cityRepository.save(city);
        }
    }

    public List<CityDto> getActiveCities() {
        List<City> cities = cityRepository.findByActive(Boolean.TRUE);
        return CityConverter.convertToDTO(cities);
    }

    public List<CityDto> getInactiveCities() {
        List<City> cities = cityRepository.findByActive(Boolean.FALSE);
        return CityConverter.convertToDTO(cities);
    }

    public void activateCity(Integer id) {
        Optional<City> s = cityRepository.findById(id);
        if (s.isPresent()) {
            City city = s.get();
            city.setActive(Boolean.FALSE);
            cityRepository.save(city);
        }
    }
}
