package com.marktProject.GroceryMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/home")
    public String displayHomePage(Model model) {

        return "home.html";
    }
}
