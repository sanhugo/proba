package ru.proba.authentication.controller;

import org.springframework.web.bind.annotation.*;
import ru.proba.authentication.dto.UserRegistrationDTO;
import ru.proba.authentication.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void add(@RequestBody UserRegistrationDTO dto) {
        userService.addUser(dto);
    }
}
