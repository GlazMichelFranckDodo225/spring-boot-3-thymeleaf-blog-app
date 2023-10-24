package com.dgmf.controller;

import com.dgmf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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

    // Handler Method to handle Message Expression Request
    // Request "http://localhost:8080/message-expression"
    @GetMapping("/message-expression")
    public String messageExpression() {
        return "message-expression";
    }

    // Handler Method to handle Link Expression Request
    // Request "http://localhost:8080/link-expression"
    @GetMapping("/link-expression")
    public String linkExpression(Model model) {
        model.addAttribute("id", 1);
        
        return "link-expression";
    }

    // Handler Method to handle Fragment Expression Request
    // Request "http://localhost:8080/fragment-expression"
    @GetMapping("/fragment-expression")
    public String fragmentExpression(Model model) {
        return "fragment-expression";
    }

    // Handler Method to handle Looping or Iteration in 
    // Thymeleaf (th:each Attribute)
    // Request "http://localhost:8080/users"
    @GetMapping("/users")
    public String users(Model model) {
        User admin = User.builder()
                .name("John Doe")
                .email("johndoe@Gmail.com")
                .gender("Male")
                .role("Admin")
                .build();

        User ovelie = User.builder()
                .name("Ovelie Ortega")
                .email("ovelieortega@Gmail.com")
                .gender("Female")
                .role("USER")
                .build();

        User gaspard = User.builder()
                .name("Gaspard Delafontaine")
                .email("gasparddelafontaine@Gmail.com")
                .gender("Male")
                .role("MANAGER")
                .build();

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(ovelie);
        users.add(gaspard);

        model.addAttribute("users", users);

        return "users";
    }

    // Handler Method to handle "IF/UNLESS" in
    // Thymeleaf (th:if and th:unless Attributes)
    // Request "http://localhost:8080/if-unless"
    @GetMapping("/if-unless")
    public String ifUnless(Model model) {
        User admin = User.builder()
                .name("John Doe")
                .email("johndoe@Gmail.com")
                .gender("Male")
                .role("ADMIN")
                .build();

        User ovelie = User.builder()
                .name("Ovelie Ortega")
                .email("ovelieortega@Gmail.com")
                .gender("Female")
                .role("USER")
                .build();

        User gaspard = User.builder()
                .name("Gaspard Delafontaine")
                .email("gasparddelafontaine@Gmail.com")
                .gender("Male")
                .role("MANAGER")
                .build();

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(ovelie);
        users.add(gaspard);

        model.addAttribute("users", users);

        return "if-unless";
    }
}
