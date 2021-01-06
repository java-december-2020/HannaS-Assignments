package com.smithHanna.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smithHanna.Lookify.Models.Music;
import com.smithHanna.Lookify.Services.MusicService;

@Controller
public class LookifyController {

	private MusicService mService; 
	
	public LookifyController(MusicService musicService) {
		this.mService = musicService; 
	}
	
	@GetMapping("/")
	public String index() {
		return "Index.jsp"; 
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Music> allSongs = this.mService.findAllSongs();
		model.addAttribute("allSongs", allSongs);
		return "dashboard.jsp"; 
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song")Music song) {
		return "newSong.jsp"; 
	}
	
	
	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Music song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp"; 
		} this.mService.createSong(song);
		return "redirect:/dashboard"; 
	}
	
	@GetMapping("/songs/{id}")
	public String findSong(@PathVariable("id")Long id, Model model) {
		Music findSong = this.mService.getSongById(id);
		model.addAttribute("song", findSong);
		return "showSong.jsp"; 
	}
	
	@GetMapping("/search/topten")
	public String topTen(Model model) {
		List<Music> topTenSongs = this.mService.findAllByRating();
		model.addAttribute("ratings", topTenSongs);
		return "topTen.jsp"; 
	}
	
	@GetMapping("/search/{artist}")
	public String searchByArtist(@PathVariable("artist")String artist, Model model) {
		List<Music> music = this.mService.findByArtist(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", music);
		return "searchByArtist.jsp"; 
	}
	@RequestMapping("/songs/search")
	public String Search(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("songs",	mService.findByArtist(artist));
		model.addAttribute("artist", artist);
		return "searchByArtist.jsp";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id")Long id) {
		this.mService.deleteSong(id);
		return "redirect:/dashboard"; 
	}
	
}
