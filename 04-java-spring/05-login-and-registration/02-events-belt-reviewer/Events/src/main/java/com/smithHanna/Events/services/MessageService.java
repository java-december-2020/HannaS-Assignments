package com.smithHanna.Events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smithHanna.Events.models.Event;
import com.smithHanna.Events.models.Message;
import com.smithHanna.Events.repositories.MessageRepository;

@Service
public class MessageService {
	
	private MessageRepository mRepo; 
	
	public MessageService(MessageRepository messageRepo) {
		this.mRepo = messageRepo;  
		
	}
	
	public Message createMessage(Message message) {
		return this.mRepo.save(message);
	}

	public List<Message> getMessageByEvent(Event event){
		return this.mRepo.findByEvent(event);
	}
}
