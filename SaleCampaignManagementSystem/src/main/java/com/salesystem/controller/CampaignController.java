package com.salesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesystem.model.Campaign;
import com.salesystem.model.CampaignDTO;
import com.salesystem.service.CampaignService;

import jakarta.validation.Valid;

@RestController
public class CampaignController {

	@Autowired
	private CampaignService campaignService;
	
	@PostMapping("/campaigns/add-campaign")
	public ResponseEntity<String> addCampaignHandler(@Valid @RequestBody CampaignDTO campaign)
	{
		String message = campaignService.addCampaign(campaign);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/campaigns")
	public ResponseEntity<List<Campaign>> getCampaignssHandler()
	{
		List<Campaign> list = campaignService.getAllCampaigns();
		
		return new ResponseEntity<List<Campaign>>(list,HttpStatus.ACCEPTED);
	}
}
