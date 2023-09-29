package com.dgmf.controller;

import com.dgmf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    // Handler Method for the Http
    // Request "http://localhost:8080/variable-expression"
    // This Method is used to handle "variable-expression" Request
    @GetMapping("/variable-expression")
    public String variableExpression(Model model) {
        User user = User.builder()
                .name("John Doe")
                .email("johndoe@gmail.com")
                .role("ADMIN")
                .gender("Male")
                .build();

        model.addAttribute("user", user);

        return "variable-expression";
    }

    // Handler Method for the Http
    // Request "http://localhost:8080/selection-expression"
    // This Method is used to handle "selection-expression" Request
    @GetMapping("/selection-expression")
    public String selectionExpression(Model model) {
        User user = User.builder()
                .name("John Doe")
                .email("johndoe@gmail.com")
                .role("ADMIN")
                .gender("Male")
                .build();

        model.addAttribute("user", user);

        return "selection-expression";
    }

    // Handler Method to handler Message Expression Request
    // Request "http://localhost:8080/message-expression"
    @GetMapping("/message-expression")
    public String messageExpression() {
        return "message-expression";
    }

    // Handler Method to handler Link Expression Request
    // Request "http://localhost:8080/link-expression"
    @GetMapping("/link-expression")
    public String linkExpression(Model model) {
        model.addAttribute("id", 1);
        
        return "link-expression";
    }
}
