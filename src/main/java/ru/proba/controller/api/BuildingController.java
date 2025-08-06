package ru.proba.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    @PostMapping("/add")
    public String add() {
        return "Added";
    }

}
