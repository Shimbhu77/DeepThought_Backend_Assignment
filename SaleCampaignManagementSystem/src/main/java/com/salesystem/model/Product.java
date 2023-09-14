package com.salesystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	
    @Id
    private String id;
    
    @Size(min = 3, message = "product should have title with at least 3 characters.")
    private String title;
    private String description;
    private double mrp;
    private double currentPrice;
    private double discount;
    private int inventory;
    
    
}