package com.marktProject.GroceryMarket.controller;

import com.marktProject.GroceryMarket.model.Registration;
import com.marktProject.GroceryMarket.model.User;
import com.marktProject.GroceryMarket.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

// The controller class presents the UI layer.

@Controller
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String displayRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration.html";
    }

    @PostMapping("/createUser")
    public String registerUser(@Valid @ModelAttribute("user") User user, Errors errors) {

        if (errors.hasErrors())
            return "registration.html";

        return userService.createNewUser(user) ? "redirect:/login?register=true" : "registration.html";

    }
}
