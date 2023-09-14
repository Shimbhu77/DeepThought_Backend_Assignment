package com.salesystem.service;

import java.util.List;

import com.salesystem.exceptions.ProductException;
import com.salesystem.model.CampaignDiscount;
import com.salesystem.model.Product;

public interface ProductService {
	
	public String addProduct(Product product) throws ProductException;
	public List<Product> getProducts(Integer pageNumber, Integer numberOfRecords);
	public List<CampaignDiscount> getProductPricingHistory(String id);

}
