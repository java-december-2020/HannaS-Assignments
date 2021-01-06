package com.smithHanna.Lookify.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.smithHanna.Lookify.Models.Music;

public interface LookifyRepository extends CrudRepository<Music, Long> {
	
	List<Music> findAll();
	
	List<Music> findByArtistContaining(String search);
	
	List<Music> findByOrderByRatingDesc();
	
	
	

}
