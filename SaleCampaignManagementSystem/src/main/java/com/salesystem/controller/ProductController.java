package com.salesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salesystem.exceptions.ProductException;
import com.salesystem.model.CampaignDiscount;
import com.salesystem.model.Product;
import com.salesystem.service.ProductService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/products/add-product")
	public ResponseEntity<String> addProductHandler(@Valid @RequestBody Product product) throws ProductException
	{
		String message = productService.addProduct(product);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProductsHandler(@RequestParam("page") Integer page,@RequestParam("pageSize") Integer pageSize)
	{
		List<Product> list = productService.getProducts(page,pageSize);
		
		return new ResponseEntity<List<Product>>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products/{product-id}")
	public ResponseEntity<List<CampaignDiscount>> getProductPricingHistoryandler(@PathParam("product-id") String productId)
	{
		List<CampaignDiscount> list = productService.getProductPricingHistory(productId);
		
		return new ResponseEntity<List<CampaignDiscount>>(list,HttpStatus.ACCEPTED);
	}
}
