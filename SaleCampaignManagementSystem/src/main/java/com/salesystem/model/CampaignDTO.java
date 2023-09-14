package com.salesystem.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CampaignDTO {

	private LocalDate startDate;
    private LocalDate endDate;
    private String title;
}
