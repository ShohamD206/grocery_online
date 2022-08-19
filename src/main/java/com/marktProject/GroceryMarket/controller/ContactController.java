package com.marktProject.GroceryMarket.controller;

import com.marktProject.GroceryMarket.model.Contact;
import com.marktProject.GroceryMarket.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());

        return "contact.html";
    }

    @PostMapping("/sendMsg")
    public String sendMessage(Model model, @Valid @ModelAttribute("contact") Contact contact, Errors errors) {

        if (errors.hasErrors()) {
            log.info("Contact form validation failed: " + errors);
            return "contact.html";
        }

        contactService.createContact(contact);

        return "redirect:/contact";
    }
}
