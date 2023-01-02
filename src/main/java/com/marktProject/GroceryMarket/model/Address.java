package com.marktProject.GroceryMarket.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int addressId;

    @NotBlank(message = "Required Main address!")
    @Size(min = 4, message = "Address must be at least 4 characters long!")
    private String address1;

    private String address2;

    @NotBlank(message = "Required to add City!")
    @Size(min = 3, message = "City must be at least 3 characters long!")
    private String city;

    @NotBlank(message = "Required State!")
    @Size(min = 3, message = "State must be at least 3 characters long!")
    private String state;

    @NotBlank(message = "Required to enter Zip Code!")
    @Pattern(regexp = "[0-9]", message = "Zip Code must contain digits only!")
    private String zipCode;
}
