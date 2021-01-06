package com.smithHanna.Lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smithHanna.Lookify.Models.Music;
import com.smithHanna.Lookify.Services.MusicService;

@RestController
@RequestMapping("/api")
public class LookifyApi {
	@Autowired
	private MusicService mService;
	
	@GetMapping("/music")
	public List<Music> allMusic(){
		return this.mService.findAllSongs();
	}
	@PostMapping("/music")
	public Music createSong(Music newSong) {
		return this.mService.createSong(newSong);
	}
	@GetMapping("/music/{id}")
	public Music getSpecificSong(@PathVariable("id") Long id) {
		return this.mService.getSongById(id);
	}
	@PutMapping("/music/{id}")
	public Music updateSong(@PathVariable("id")Long id, Music updatedSong) {
		return this.mService.updateSong(updatedSong);
	}
	@DeleteMapping("music/{id}")
	public void deleteSong(@PathVariable("id")Long id) {
		this.mService.deleteSong(id);
	}
	
}
