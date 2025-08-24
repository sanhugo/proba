package ru.proba.authentication.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.proba.authentication.dto.UserRegistrationDTO;
import ru.proba.authentication.entity.User;
import ru.proba.authentication.enums.Role;
import ru.proba.authentication.repository.UserRepository;


import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserRegistrationDTO dto)
    {
        Optional<User> y = userRepository.findByLogin(dto.getLogin());
        if (y.isEmpty())
        {
            User newUser= new User();
            newUser.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
            newUser.setLogin(dto.getLogin());
            Set<Role> r = new TreeSet<>();
            r.add(Role.USER);
            newUser.setRoles(r);
            userRepository.save(newUser);
        }
    }
}
