package com.salesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesystem.model.CampaignDiscount;

@Repository
public interface CampaignDiscountRepository extends JpaRepository<CampaignDiscount, String> {

	public List<CampaignDiscount> findByProductId(String id);
}
