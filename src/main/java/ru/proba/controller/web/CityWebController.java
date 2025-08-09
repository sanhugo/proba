package ru.proba.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.proba.DTO.city.CityAdditionDTO;
import ru.proba.DTO.city.CityVisualDTO;
import ru.proba.service.CityService;

import java.util.List;

@Controller
public class CityWebController {

    private final CityService cityService;

    public CityWebController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public String getCities(Model model) {
        List<CityVisualDTO> cities = cityService.getCities();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/cities/add")
    public String showAddCityForm(Model model) {
        model.addAttribute("city", new CityAdditionDTO());
        return "addCity";
    }

    @PostMapping("/cities/deactivate")
    public String deactivate(@RequestParam Integer id) {
        cityService.blockCity(id);
        return "redirect:/cities";
    }

    @PostMapping("/cities/activate")
    public String activate(@RequestParam Integer id) {
        cityService.activateCity(id);
        return "redirect:/cities";
    }

}
