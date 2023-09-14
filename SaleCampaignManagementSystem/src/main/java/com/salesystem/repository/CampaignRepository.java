package com.salesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesystem.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer>{

}
