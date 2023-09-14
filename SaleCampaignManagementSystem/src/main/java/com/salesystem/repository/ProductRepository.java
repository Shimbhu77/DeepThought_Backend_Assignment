package com.salesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.salesystem.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, PagingAndSortingRepository<Product, String>{

}
