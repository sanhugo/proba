package ru.proba.converter;

import ru.proba.DTO.city.CityDto;
import ru.proba.DTO.city.CityVisualDTO;
import ru.proba.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityConverter {

    public static List<CityVisualDTO> convertToDTO(List<City> cities) {
        List<CityVisualDTO> citiesDto = new ArrayList<>();
        for (City city : cities) {
            CityVisualDTO cityDto = new CityVisualDTO(city.getId(), city.getName(), city.getTimezone(),city.getActive());
            citiesDto.add(cityDto);
        }
        return citiesDto;
    }

    public static List<CityDto> convertToDto(List<City> cities) {
        List<CityDto> citiesDto = new ArrayList<>();
        for (City city : cities) {
            CityDto cityDto = new CityDto(city.getId(),city.getName());
            citiesDto.add(cityDto);
        }
        return citiesDto;
    }
}
