package com.salesystem.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesystem.exceptions.CampaignException;
import com.salesystem.exceptions.ProductException;
import com.salesystem.model.Campaign;
import com.salesystem.model.CampaignDiscount;
import com.salesystem.model.CampaignDiscountDTO;
import com.salesystem.model.Product;
import com.salesystem.repository.CampaignDiscountRepository;
import com.salesystem.repository.CampaignRepository;
import com.salesystem.repository.ProductRepository;
import com.salesystem.service.CampaignDiscountService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CampaignDiscountServiceImpl implements CampaignDiscountService{

	@Autowired
	private CampaignDiscountRepository campaignDiscountRepository;
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public String addCampaignDiscount(CampaignDiscountDTO campaignDiscount) throws CampaignException, ProductException {
		
		log.info("adding discount ...");
		Optional<Campaign> opt = campaignRepository.findById(campaignDiscount.getCampaignId());
		log.info("campaign found ...");
		if(opt.isPresent())
		{
			Campaign campaign = opt.get();
			
			
			Optional<Product> optProduct = productRepository.findById(campaignDiscount.getProductId());
			
			if(optProduct.isPresent())
			{
				log.info("creating discount  ...");
				
				Optional<CampaignDiscount> optdiscount = campaignDiscountRepository.findById(campaignDiscount.getId());
				if(optdiscount.isPresent())
				{
					throw new ProductException("Campaign discount is already found with this id : "+campaignDiscount.getId());
					
				}
				CampaignDiscount discount = new CampaignDiscount();
				discount.setId(campaignDiscount.getId());
				discount.setProductId(campaignDiscount.getProductId());
				discount.setDiscount(campaignDiscount.getDiscount());
				
				campaign.getCampaignDiscounts().add(discount);
				
				log.info("created discount ...");
				
				campaignRepository.save(campaign);
				
				return "campaign Discount added Successfully.";
			}
			throw new ProductException("Product is not found with this id : "+campaignDiscount.getProductId());
			
			
		}
		
		throw new CampaignException("Campaign is not found with this id : "+campaignDiscount.getCampaignId());
		
	}

}
