package com.smithHanna.Relationships.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.smithHanna.Relationships.models.Person; 

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findAll();
	
	List<Person> findByLicenseIdIsNull();
	
	@Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
	List<Person> findByNoLicense();
}
