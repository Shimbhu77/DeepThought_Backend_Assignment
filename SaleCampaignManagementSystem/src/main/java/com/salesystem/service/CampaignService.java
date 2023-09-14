package com.salesystem.service;

import java.util.List;

import com.salesystem.model.Campaign;
import com.salesystem.model.CampaignDTO;

public interface CampaignService {

	public String addCampaign(CampaignDTO campaign);
	public List<Campaign> getAllCampaigns();
}
