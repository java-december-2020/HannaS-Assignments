package com.smithHanna.Events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.Events.models.User; 

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);
	boolean existsByEmail(String email);
	
}
