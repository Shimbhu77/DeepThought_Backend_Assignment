package com.DeepThought.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.DeepThought.exceptions.EventException;
import com.DeepThought.model.Event;
import com.DeepThought.model.EventDTO;
import com.DeepThought.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepo;
	
	@Override
	public Event getEventById(Integer event_id) throws EventException {
		
		Optional<Event> optEvent = eventRepo.findById(event_id);
		
		if(optEvent.isPresent())
		{
			Event event = optEvent.get();
			
			return event;
		}
		
		throw new EventException("No Event found with this id : "+event_id);
	}

	@Override
	public Integer createEvent(EventDTO event_dto) throws EventException {
		
		Event event = new Event();
		
		event.setName(event_dto.getName());
		event.setTagline(event_dto.getTagline());
		event.setSchedule(event_dto.getSchedule());
		event.setDescription(event_dto.getDescription());
		event.setImage(event_dto.getImage());
		
		event.setModerator(event_dto.getModerator());
		event.setCategory(event_dto.getCategory());
		event.setSubCategory(event_dto.getSubCategory());
		event.setRigorRank(event_dto.getRigorRank());
		
		eventRepo.save(event);
		
		return event.getUid();
	}

	@Override
	public Integer updateEvent(EventDTO event_dto, Integer event_id) throws EventException {
		
        Optional<Event> optEvent = eventRepo.findById(event_id);
		
		if(optEvent.isPresent())
		{
			Event event = optEvent.get();
			
			event.setName(event_dto.getName());
			event.setTagline(event_dto.getTagline());
			event.setSchedule(LocalDateTime.now());
			event.setDescription(event_dto.getDescription());
			event.setImage(event_dto.getImage());
			
			event.setModerator(event_dto.getModerator());
			event.setCategory(event_dto.getCategory());
			event.setSubCategory(event_dto.getSubCategory());
			event.setRigorRank(event_dto.getRigorRank());
			
			eventRepo.save(event);
			
			return event.getUid();
		
		}
		
		throw new EventException("No Event found for updating with this id : "+event_id+".");
	}

	@Override
	public String deleteEventById(Integer event_id) throws EventException {

		Optional<Event> optEvent = eventRepo.findById(event_id);
		
		if(optEvent.isPresent())
		{
			Event event = optEvent.get();
			
		    eventRepo.delete(event);
		    
		    return "Event deleted which event_id is : "+event.getUid();
		}
		
		throw new EventException("No Event found for deleting with this id : "+event_id+".");
	}

	@Override
	public Page<Event> getRecentEvents(int pageNumber, int eventsPerPage) {
        PageRequest pageRequest = PageRequest.of(pageNumber, eventsPerPage, Sort.by("schedule").descending());
        return eventRepo.findAll(pageRequest);
    }

}
