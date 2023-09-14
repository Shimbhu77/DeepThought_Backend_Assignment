package com.salesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesystem.exceptions.CampaignException;
import com.salesystem.exceptions.ProductException;
import com.salesystem.model.CampaignDiscount;
import com.salesystem.model.CampaignDiscountDTO;
import com.salesystem.service.CampaignDiscountService;

import jakarta.validation.Valid;

@RestController
public class CampaignDiscountController {

	@Autowired
	private CampaignDiscountService campaignDiscountService;
	
	@PostMapping("/campaign-discounts/add-campaign-discount")
	public ResponseEntity<String> addCampaignHandler(@Valid @RequestBody CampaignDiscountDTO campaign) throws CampaignException, ProductException
	{
		String message = campaignDiscountService.addCampaignDiscount(campaign);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
}
