package ru.proba.controller.api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.proba.DTO.user.UserRegistrationDTO;
import ru.proba.service.UserService;

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
