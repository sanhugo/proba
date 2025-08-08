package ru.proba.converter;

import ru.proba.DTO.CityDto;
import ru.proba.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityConverter {

    public static List<CityDto> convertToDTO(List<City> cities) {
        List<CityDto> citiesDto = new ArrayList<>();
        for (City city : cities) {
            CityDto cityDto = new CityDto(city.getId(), city.getName(), city.getTimezone());
            citiesDto.add(cityDto);
        }
        return citiesDto;
    }
}
