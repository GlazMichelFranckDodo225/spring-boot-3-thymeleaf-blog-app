package com.dgmf.controller;

import com.dgmf.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {
    // Handler Method to handle User Registration Page Request
    //  "http://localhost:8080/register"
    @GetMapping("/register")
    public String userRegistrationPage(Model model) {
        // Empty UserForm Model Object to store Form Data
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        // List of Professions
        List<String> listProfessions = Arrays.asList(
                "Developer",
                "Tester",
                "Architect"
        );
        model.addAttribute("listProfessions", listProfessions);

        return "register-form";
    }

}
