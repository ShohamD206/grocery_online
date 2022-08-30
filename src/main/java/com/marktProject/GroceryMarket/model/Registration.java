package com.marktProject.GroceryMarket.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Registration {

    @NotBlank(message = "Required name!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Required Email!")
    @Email(message = "Please provide a valid Email")
    private String email;

    @NotBlank(message = "Required password!")
    @Size(min = 6, message = "Password must be 6 characters at least!")
    // @Pattern(regexp = "^(?=.*/d)(?=.*[a-z])(?=.*[A-Z])", message = "Password must contain: Uppercase, Lowercase, Number")
    private String password;

}
