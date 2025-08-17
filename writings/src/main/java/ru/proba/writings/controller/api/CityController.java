package ru.proba.writings.controller.api;

import org.springframework.web.bind.annotation.*;
import ru.proba.writings.DTO.city.CityAdditionDTO;
import ru.proba.writings.DTO.city.CityDto;
import ru.proba.writings.DTO.city.CityVisualDTO;
import ru.proba.writings.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CityAdditionDTO cityDto) {
        cityService.save(cityDto);
    }

    @GetMapping("/dto")
    public CityAdditionDTO setEmptyDTO()
    {
        return new CityAdditionDTO();
    }

    @GetMapping()
    public List<CityVisualDTO> getCities() {
        return cityService.getCities(); // Возвращает JSON с cities
    }

    @GetMapping("/active")
    public List<CityDto> getActiveCities() {
        return cityService.getActiveCities();
    }
}
