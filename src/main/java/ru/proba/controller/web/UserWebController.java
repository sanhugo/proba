package ru.proba.controller.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserWebController {

    @GetMapping("/add")
    public String add() {
        return "Added";
    }
}
