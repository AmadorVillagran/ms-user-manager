package com.amaris.usermanager.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerImpl {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
