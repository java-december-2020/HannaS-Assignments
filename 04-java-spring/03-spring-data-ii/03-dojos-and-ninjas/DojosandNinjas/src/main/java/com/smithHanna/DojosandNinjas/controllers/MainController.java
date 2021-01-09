package com.smithHanna.DojosandNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smithHanna.DojosandNinjas.models.Dojo;
import com.smithHanna.DojosandNinjas.models.Ninja;
import com.smithHanna.DojosandNinjas.services.NinjaDojoService;

@Controller
public class MainController {

	@Autowired
	private NinjaDojoService nService; 
	

	
	@GetMapping("/")
	public String index(Model model) {
		List<Dojo> allDojos = this.nService.findAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "index.jsp"; 
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo, Model model) {
		return "newdojo.jsp";
	}
	
	@PostMapping("dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newdojo.jsp"; 
		}
		this.nService.createDojo(dojo);
		return "redirect:/"; 
	}
	
	@GetMapping("/dojos/{id}")
		public String ninjasInDojo(@PathVariable("id") Long id, Model model) {
			Dojo dojo = this.nService.findDojoById(id);
			model.addAttribute("dojo", dojo);
			return "dojo.jsp";
		}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> allDojos = this.nService.findAllDojos(); 
		model.addAttribute("allDojos", allDojos);
		return "newninja.jsp"; 
	}
	
	@PostMapping("ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newninja.jsp"; 
		}else {
		this.nService.createNinja(ninja);
		return "redirect:/";
		}
	}
	@GetMapping("/ninjas")
	public String allNinjas(Model model) {
		List<Ninja> allNinjas = this.nService.getAllNinjas();
		model.addAttribute("allNinjas", allNinjas);
		return "ninjas.jsp"; 
	}
}
