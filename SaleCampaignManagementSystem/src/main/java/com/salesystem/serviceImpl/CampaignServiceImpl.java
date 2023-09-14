package com.salesystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesystem.model.Campaign;
import com.salesystem.model.CampaignDTO;
import com.salesystem.repository.CampaignRepository;
import com.salesystem.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Override
	public String addCampaign(CampaignDTO campaigndto) {
		
		Campaign campaign = new Campaign();
		
		campaign.setEndDate(campaigndto.getEndDate());
		campaign.setStartDate(campaigndto.getStartDate());
		campaign.setTitle(campaigndto.getTitle());
		
		campaignRepository.save(campaign);
		
		return "campaign added successfully.";
	}

	@Override
	public List<Campaign> getAllCampaigns() {
		
		List<Campaign> list = campaignRepository.findAll();
		
		return list;
	}

	

}
