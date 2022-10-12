package com.marktProject.GroceryMarket.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler (Exception e) {

        ModelAndView exceptionPage = new ModelAndView();
        exceptionPage.setViewName("exception");
        exceptionPage.addObject("errorMsg", e.getMessage());

        return exceptionPage;
    }
}
