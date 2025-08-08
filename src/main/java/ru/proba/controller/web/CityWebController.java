package ru.proba.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.proba.DTO.CityAdditionDTO;
import ru.proba.DTO.CityDto;
import ru.proba.service.CityService;

import java.time.ZoneId;
import java.util.List;

@Controller
public class CityWebController {

    private final CityService cityService;

    public CityWebController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public String getCities(Model model) {
        List<CityDto> cities = cityService.getActiveCities();
        model.addAttribute("cities", cities);
        return "cities"; // Возвращает шаблон cities.html
    }

    @GetMapping("/cities/add")
    public String showAddCityForm(Model model) {
        model.addAttribute("city", new CityAdditionDTO());
        model.addAttribute("timezones", ZoneId.getAvailableZoneIds().stream().sorted().toList());
        return "addCity";
    }


    @PostMapping("/cities/add")
    public String add(@ModelAttribute CityAdditionDTO cityDto) {
        cityService.save(cityDto);
        return "redirect:/cities";
    }

    @PostMapping("/cities/deactivate")
    public String deactivate(@RequestParam Integer id) {
        cityService.blockCity(id);
        return "redirect:/cities";
    }

    @PutMapping("/cities/activate")
    public String activate(@RequestParam Integer id) {
        cityService.activateCity(id);
        return "redirect:/cities";
    }
}
