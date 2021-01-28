package com.smithHanna.Events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.Events.models.Event;
import com.smithHanna.Events.models.Message;
import com.smithHanna.Events.models.User;
import com.smithHanna.Events.repositories.EventRepository;
import com.smithHanna.Events.repositories.MessageRepository; 

@Service
public class EventService {

	@Autowired
	private EventRepository eRepo; 
	@Autowired
	private MessageRepository mRepo; 
	
	public Event findById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	public EventService(EventRepository eventRepo) {
		this.eRepo = eventRepo; 
	}
	
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	public Event updateEvent(Event updatedEvent) {
		return this.eRepo.save(updatedEvent);
	}
	
	public List<Event> eventByState(String state){
		return this.eRepo.findByState(state);
	}
	
	public List<Event> eventOutOfState(String state){
		return this.eRepo.findByStateIsNot(state);
	}
	
	public List<Event> allEvents(){
		return this.eRepo.findAll(); 
	}
	
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	
	public void message(User user, Event event, String content) {
		this.mRepo.save(new Message(user, event, content));
	}
	
	public void addAttendee(Event event, User user) {
		List<User> currentAttendees = event.getAttendees(); 
		currentAttendees.add(user);
		this.eRepo.save(event);
	}
	
	public void removeAttendee(Event event, User user) {
		List<User> currentAttendees = event.getAttendees();
		currentAttendees.remove(user);
		this.eRepo.save(event);
	}
}
