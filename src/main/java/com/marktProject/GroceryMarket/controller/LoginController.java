package com.marktProject.GroceryMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String displayLoginPage(Model model) {

        return "login.html";
    }
}
