package com.DeepThought.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DeepThought.exceptions.EventException;
import com.DeepThought.model.Event;
import com.DeepThought.model.EventDTO;
import com.DeepThought.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("/api/v3/app/events")
	public ResponseEntity<Event> getEventById(@RequestParam("id") Integer id) throws EventException
	{
		Event event = eventService.getEventById(id);
		
		return new ResponseEntity<Event>(event,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/api/v3/app/event")
	  public ResponseEntity<Page<Event>> getEvents(
	            @RequestParam(defaultValue = "latest") String type,
	            @RequestParam(defaultValue = "5") int limit,
	            @RequestParam(defaultValue = "1") int page
	    ) {
	        if (type.equalsIgnoreCase("latest")) {
	            Page<Event> events = eventService.getRecentEvents(page - 1, limit);
	            return ResponseEntity.ok(events);
	        } else {
	            // Handle other types of events if needed
	            return ResponseEntity.badRequest().build();
	        }
	    }
	
	@PostMapping("/api/v3/app/events")
	public ResponseEntity<Integer> createEvent(@RequestBody EventDTO dto) throws EventException
	{
		Integer event_id = eventService.createEvent(dto);
		
		return new ResponseEntity<Integer>(event_id,HttpStatus.CREATED);
		
	}
	@PutMapping("/api/v3/app/events/{id}")
	public ResponseEntity<Integer> updateEvent(@RequestBody EventDTO dto,@PathVariable("id") Integer id) throws EventException
	{
		Integer event_id = eventService.updateEvent(dto,id);
		
		return new ResponseEntity<Integer>(event_id,HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("/api/v3/app/events/{id}")
	public ResponseEntity<String> deleteEventById(@PathVariable("id") Integer id) throws EventException
	{
		String event = eventService.deleteEventById(id);
		
		return new ResponseEntity<String>(event,HttpStatus.ACCEPTED);
		
	}
}
