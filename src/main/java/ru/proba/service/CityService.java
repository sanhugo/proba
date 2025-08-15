package ru.proba.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.proba.DTO.city.CityAdditionDTO;
import ru.proba.DTO.city.CityDto;
import ru.proba.DTO.city.CityVisualDTO;
import ru.proba.converter.CityConverter;
import ru.proba.model.Building;
import ru.proba.model.City;
import ru.proba.repositories.CityRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CityService {

    private final CityRepository cityRepository;
    private final BuildingService buildingService;

    public CityService(CityRepository cityRepository, BuildingService buildingService) {
        this.cityRepository = cityRepository;
        this.buildingService = buildingService;
    }

    public void save(CityAdditionDTO city) {
        if (cityRepository.findByNameAndTimezone(city.getName().trim(),city.getTimezone()).isEmpty())
        {
            City cityEntity = new City();
            cityEntity.setName(city.getName());
            cityEntity.setTimezone(city.getTimezone());
            cityEntity.setActive(Boolean.TRUE);
            cityRepository.save(cityEntity);
        }
    }

    public void blockCity(Integer cityId) {
        Optional<City> s = cityRepository.findById(cityId);
        if (s.isPresent()) {
            Long buildings = buildingService.countActiveByCity(cityId); //сначала посчитать есть ли активные здания в городе
            if (buildings == 0) {
                City city = s.get();
                city.setActive(Boolean.FALSE);
                cityRepository.save(city);
            }
        }
    }

    public List<CityVisualDTO> getCities() {
        List<City> cities = cityRepository.findAll();
        return CityConverter.convertToDTO(cities);
    }

    public void activateCity(Integer id) {
        Optional<City> s = cityRepository.findById(id);
        if (s.isPresent()) {
            City city = s.get();
            city.setActive(Boolean.TRUE);
            cityRepository.save(city);
        }
    }

    public List<CityDto> getActiveCities() {
        List<City> cities = cityRepository.findByActive(Boolean.TRUE);
        return CityConverter.convertToDto(cities);
    }

    public String getCityName(Integer id) {
        Optional<City> s = cityRepository.findById(id);
        if (s.isPresent()) {
            return s.get().getName().trim();
        }
        else return null;
    }
}
