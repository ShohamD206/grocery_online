package com.marktProject.GroceryMarket.controller;

import com.marktProject.GroceryMarket.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// The controller class presents the UI layer.

@Controller
public class HomeController {

    @GetMapping("/home")
    public String displayHomePage(Model model) {

        model.addAttribute("registration", new Registration());

        return "home.html";
    }

//    @GetMapping("/home/registration")
//    public String displayRegistration(Model model) {
//
//        model.addAttribute("registration", new Registration());
//        return "home.html";
//    }
}
