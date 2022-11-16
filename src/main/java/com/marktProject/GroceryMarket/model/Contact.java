package com.marktProject.GroceryMarket.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@Entity
@Table(name = "inquiry")
public class Contact extends BaseEntity {

    @Id    // -> Because it's primary key value
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int inquiryId;  // --> Primary Key
    private String status;

    @NotBlank(message = "Please enter name!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Please enter Email!")
    @Email(message = "Please provide a valid Email")
    private String email;

    @NotBlank(message = "Please enter phone number!")
    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits!")
    private String mobileNum;

    @NotBlank(message = "Please enter subject!")
    @Size(min = 5, message = "Subject must be at least 5 chars long!")
    private String subject;

    @NotBlank(message = "Please enter message!")
    @Size(min = 10, message = "Message must be at least 10 characters!")
    private String message;
}
