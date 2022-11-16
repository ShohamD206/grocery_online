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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

// The controller class presents the UI layer.

@Controller
@Slf4j
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

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

        contactService.saveMessageDetails(contact);  // after this, move to service layer.

        return "redirect:/contact";
    }

    @GetMapping("/displayInquiries")  // dashboard.html --> Dashboard buttons.
    public ModelAndView displayInquiries(Model model) {
        // this method role is to display all the inquiries in the database.
        // this method will use the service class to find inquiries with status OPEN.

        ModelAndView modelAndView = new ModelAndView();
        List<Contact> inquiriesList = contactService.findInquiriesByStatus();
        modelAndView.setViewName("inquiries");
        modelAndView.addObject("inquiriesList", inquiriesList);

        return modelAndView;
    }

    @GetMapping("/closeInquiry")
    public String closeInquiry(@RequestParam int id) {

        contactService.updateInquiryStatus(id);
        return "redirect:/displayInquiries";
    }
}
