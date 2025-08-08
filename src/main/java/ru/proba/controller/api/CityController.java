package ru.proba.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.proba.DTO.CityAdditionDTO;
import ru.proba.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public String add(@RequestBody CityAdditionDTO cityDto) {
        cityService.save(cityDto);
        return "Added";
    }
}
