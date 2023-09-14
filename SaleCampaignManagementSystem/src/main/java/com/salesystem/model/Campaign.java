package com.salesystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Campaign {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    
    @Size(min = 3, message = "campaign should have title with at least 3 characters.")
    private String title;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<CampaignDiscount> campaignDiscounts = new ArrayList<>();
    
}
