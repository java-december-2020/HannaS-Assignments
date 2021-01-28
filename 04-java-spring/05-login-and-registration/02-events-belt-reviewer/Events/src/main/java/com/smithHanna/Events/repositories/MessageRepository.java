package com.smithHanna.Events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.Events.models.Event;
import com.smithHanna.Events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

	List<Message> findByEvent(Event event);
}
