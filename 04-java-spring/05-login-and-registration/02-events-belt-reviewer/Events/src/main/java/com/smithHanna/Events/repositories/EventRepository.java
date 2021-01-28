package com.smithHanna.Events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.smithHanna.Events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

	List<Event> findAll();
	List<Event> findByState(String state);
	List<Event> findByStateIsNot(String state);
	
}
