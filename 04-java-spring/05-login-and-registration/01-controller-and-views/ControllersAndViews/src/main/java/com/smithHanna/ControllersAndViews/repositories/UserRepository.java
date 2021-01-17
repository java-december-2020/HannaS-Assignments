package com.smithHanna.ControllersAndViews.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.ControllersAndViews.models.User;

@Repository 
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);
}
