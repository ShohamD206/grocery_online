package com.marktProject.GroceryMarket.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    private String message;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayLoginPage(@RequestParam(required = false) String error,
                                   @RequestParam(required = false) String logout,
                                   Model model) {

        if (error != null)
            message = "Password OR Username is incorrect";

        if (logout != null)
            message = "You have been successfully Logged out";

        model.addAttribute("message", message);
        return "login.html";
    }

    @GetMapping("/logout")
    public String displayLogoutPage(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null)
            new SecurityContextLogoutHandler().logout(request, response, auth);

        return "redirect:/login?logout=true";
    }
}
