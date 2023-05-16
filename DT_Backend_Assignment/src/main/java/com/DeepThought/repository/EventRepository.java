package com.DeepThought.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeepThought.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	
}
