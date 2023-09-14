package com.salesystem.service;

import com.salesystem.exceptions.CampaignException;
import com.salesystem.exceptions.ProductException;
import com.salesystem.model.CampaignDiscountDTO;

public interface CampaignDiscountService {

	public String addCampaignDiscount(CampaignDiscountDTO campaignDiscount) throws CampaignException, ProductException;
}
