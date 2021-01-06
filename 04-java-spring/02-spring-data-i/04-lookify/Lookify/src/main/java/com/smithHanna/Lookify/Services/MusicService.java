package com.smithHanna.Lookify.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smithHanna.Lookify.Models.Music;
import com.smithHanna.Lookify.repositories.LookifyRepository;

@Service
public class MusicService {

	private LookifyRepository lrepo; 
	
	public MusicService(LookifyRepository musicRepo) {
		this.lrepo = musicRepo; 
	}
	
	public List<Music> findAllSongs(){
		return this.lrepo.findAll();
	}
	
	public Music createSong(Music newSong) {
		return this.lrepo.save(newSong);
	}
	
	public Music getSongById(Long id) {
		return this.lrepo.findById(id).orElse(null);
	}
	
	public Music updateSong(Music updatedSong) {
		return this.lrepo.save(updatedSong);
	}
	
	public List<Music> findAllByRating(){
		return this.lrepo.findByOrderByRatingDesc();
	}
	public List<Music> findByArtist(String artist) {
		return this.lrepo.findByArtistContaining(artist);
	}
	
	public void deleteSong(Long id) {
		this.lrepo.deleteById(id);
	}
}
