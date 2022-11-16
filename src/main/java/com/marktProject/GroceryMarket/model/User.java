package com.marktProject.GroceryMarket.model;

import com.marktProject.GroceryMarket.annotation.FieldsMatch;
import com.marktProject.GroceryMarket.annotation.SecuredPassword;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@FieldsMatch.List({
        @FieldsMatch(fieldOne = "password", fieldTwo = "confirmPassword", message = "Passwords do not match!"),
        @FieldsMatch(fieldOne = "email", fieldTwo = "confirmEmail", message = "Emails do not match!")
})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int userId;

    @NotBlank(message = "Required Name!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Required Mobile Number!")
    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Required Email!")
    @Email(message = "Email address is not valid!")
    private String email;

    @NotBlank(message = "Required Confirm Email!")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Required Password!")
    @SecuredPassword
    private String password;

    @NotBlank(message = "Confirm Password!")
    @Transient
    private String confirmPassword;
}
