package com.example.dockertest.controller;

import com.example.dockertest.model.User;
import com.example.dockertest.model.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;
import java.util.List;

@Controller
public class WebController {

    private final UserRepository userRepository;

    public WebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({"/", "/hello"})
    public String hello() {
        return "hello";
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name, Model model) {
        byte[] bytes = Base64.getDecoder().decode(name);
        name = new String(bytes);
        List<User> users = userRepository.findAll(PageRequest.of(0, 100)).getContent();
        model.addAttribute("name", name);
        model.addAttribute("users", users);
        return "welcome";
    }
}
