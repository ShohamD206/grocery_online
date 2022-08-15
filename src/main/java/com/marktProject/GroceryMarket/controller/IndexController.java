package com.marktProject.GroceryMarket.controller;

import com.marktProject.GroceryMarket.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/home")
    public String displayHomePage(Model model) {

        return "home.html";
    }
}
