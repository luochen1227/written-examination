package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @GetMapping("/HelloWorld")
    public String HelloWorld() {
        return "Hello World";
    }
}
