package com.marktProject.GroceryMarket.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private String updatedBy;
    private String createdBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
