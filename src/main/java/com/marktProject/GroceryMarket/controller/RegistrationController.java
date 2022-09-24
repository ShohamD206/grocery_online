package com.marktProject.GroceryMarket.controller;

import com.marktProject.GroceryMarket.model.Registration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class RegistrationController {

    private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/registration")
    public String displayRegistrationPage(Model model) {

        model.addAttribute("registration", new Registration());
        return "registration.html";
    }

    @PostMapping("/createUser")
    public String registerUser(Model model, @Valid @ModelAttribute("registration") Registration registration, Errors errors) {

        if (errors.hasErrors()) {
            log.info("registration form validation failed : " + errors);
            return "registration.html";
        }

        log.info(registration.toString());

        model.addAttribute("success", true);
        model.addAttribute("email", registration.getEmail());

        return "registration.html";
    }
}
