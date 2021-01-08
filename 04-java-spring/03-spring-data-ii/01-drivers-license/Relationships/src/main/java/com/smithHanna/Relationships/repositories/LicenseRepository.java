package com.smithHanna.Relationships.repositories;

import org.springframework.data.repository.CrudRepository;

import com.smithHanna.Relationships.models.License;
import java.util.List; 

public interface LicenseRepository extends CrudRepository<License, Long> {

	List<License> findAll();
	
	License findTopByOrderByIdDesc();
}
