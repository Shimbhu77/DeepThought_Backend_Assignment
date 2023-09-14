package com.salesystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesystem.exceptions.ProductException;
import com.salesystem.model.CampaignDiscount;
import com.salesystem.model.Product;
import com.salesystem.repository.CampaignDiscountRepository;
import com.salesystem.repository.ProductRepository;
import com.salesystem.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CampaignDiscountRepository campaignDiscountRepository;
	
	@Override
	public String addProduct(Product product) throws ProductException {
		
		Optional<Product> optProduct = productRepository.findById(product.getId());
		
		if(optProduct.isPresent())
		{
			throw new ProductException("Product is already found with this id : "+product.getId());
			
		}
		
		productRepository.save(product);
		
		return "Product added Successfully.";
	}

	@Override
	public List<Product> getProducts(Integer pageNumber, Integer numberOfRecords) {
		
		Pageable p = PageRequest.of(pageNumber-1, numberOfRecords);
		
		Page<Product> page= productRepository.findAll(p);
		
		List<Product> list= page.getContent();
		
		return list;
	}

	@Override
	public List<CampaignDiscount> getProductPricingHistory(String id) {
		
		List<CampaignDiscount> list = campaignDiscountRepository.findByProductId(id);
		
		return list;
	}

}
