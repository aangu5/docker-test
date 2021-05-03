package com.example.dockertest.controller;

import com.example.dockertest.model.User;
import com.example.dockertest.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class APIController {

    private final UserRepository userRepository;

    public APIController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void user(@RequestHeader String name) {
        log.info("Request received for: {}", name);
        var user = new User();
        user.setName(name);
        userRepository.save(user);
    }
}
