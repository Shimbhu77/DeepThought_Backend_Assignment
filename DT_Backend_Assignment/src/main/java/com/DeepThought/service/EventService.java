package com.DeepThought.service;

import org.springframework.data.domain.Page;

import com.DeepThought.exceptions.EventException;
import com.DeepThought.model.Event;
import com.DeepThought.model.EventDTO;

public interface EventService {

	public Event getEventById(Integer event_id) throws EventException;
	public Integer createEvent(EventDTO event_dto) throws EventException;
	public Integer updateEvent(EventDTO event_dto,Integer event_id) throws EventException;
	public String deleteEventById(Integer event_id) throws EventException;
	public Page<Event> getRecentEvents(int pageNumber, int eventsPerPage);
}
