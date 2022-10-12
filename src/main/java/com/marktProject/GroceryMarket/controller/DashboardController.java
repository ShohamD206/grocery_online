package com.marktProject.GroceryMarket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class DashboardController {

    @GetMapping("/dash")
    public String displayDashboardPage(Model model, Authentication auth) {

        model.addAttribute("username", auth.getName());
        model.addAttribute("roles", auth.getAuthorities().toString());

        log.info(auth.getAuthorities().toString());

        return "dashboard.html";
    }
}
