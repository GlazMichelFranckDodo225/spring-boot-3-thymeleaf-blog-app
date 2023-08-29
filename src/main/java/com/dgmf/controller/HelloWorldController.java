package com.dgmf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    // Handler Method for Http Request
    @GetMapping("/hello-world") // http://localhost:8080/hello-world
    public String helloworld(Model model) {
        // Store Data in the Model
        model.addAttribute("message", "Hello world !");

        // Return the View Thymeleaf Template
        return "hello-world";
    }
}
