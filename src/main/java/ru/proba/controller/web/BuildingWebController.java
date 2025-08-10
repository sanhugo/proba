package ru.proba.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.proba.DTO.building.BuildingAdditionDTO;

@Controller
@RequestMapping("/buildings")
public class BuildingWebController {

    @GetMapping()
    public String getBuildings(){
        return "buildings";
    }

    @GetMapping("/add")
    public String showAddCityForm(Model model) {
        model.addAttribute("building", new BuildingAdditionDTO());
        return "addBuilding";
    }

}
