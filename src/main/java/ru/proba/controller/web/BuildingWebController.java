package ru.proba.controller.web;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.proba.model.Building;

@RestController
@RequestMapping("/buildings")
public class BuildingWebController {

    @PostMapping("/add")
    public void addBuilding(@ModelAttribute Building building){

    }

}
