package com.smithHanna.Languages.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.Languages.Models.Language;

@Repository 
public interface LanguageRepository extends CrudRepository<Language, Long>{

	List<Language> findAll();
	
	
	
	
}
