package com.DeepThought.service;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.DeepThought.exceptions.EventException;
import com.DeepThought.model.Event;
import com.DeepThought.model.EventDTO;

public interface EventService {

	public Event getEventById(Integer event_id) throws EventException;
	public Integer createEvent(EventDTO event_dto,MultipartFile file) throws EventException, IllegalStateException, IOException;
	public Integer updateEvent(EventDTO event_dto,MultipartFile file, Integer event_id) throws EventException, IllegalStateException, IOException;
	public String deleteEventById(Integer event_id) throws EventException;
	public Page<Event> getRecentEvents(int pageNumber, int eventsPerPage);
}
