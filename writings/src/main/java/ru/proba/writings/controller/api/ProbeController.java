package ru.proba.writings.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/probes")
public class ProbeController {

    @PostMapping("/add")
    public String add() {
        return "Added";
    }
}
