package com.smithHanna.Relationships.controllers;

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

import com.smithHanna.Relationships.models.License;
import com.smithHanna.Relationships.models.Person;
import com.smithHanna.Relationships.services.DriversLicenseService;

@Controller
public class DriversLicenseController {
	@Autowired
	private DriversLicenseService dlService; 
	
	public DriversLicenseController(DriversLicenseService service) {
		this.dlService = service; 
	}
	@GetMapping("/")
	public String index(Model model) {
		List<Person> allPeople = this.dlService.getAllPeople();
		model.addAttribute("allPeople", allPeople);
		return "index.jsp"; 
	}
	
	@GetMapping("/persons/new")
	public String createPerson(@ModelAttribute("person")Person newPerson) {
		return "newperson.jsp"; 
	}
	
	@PostMapping("/persons/new")
	public String newPerson(@Valid @ModelAttribute("person") Person newPerson, BindingResult result) {
		if(result.hasErrors()) {
			return "newperson.jsp"; 
		}this.dlService.createPerson(newPerson);
		return "redirect:/"; 
	}
	@GetMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		List<Person> unlicensed = this.dlService.getUnlicensed();
		model.addAttribute("people", unlicensed);
		return "newlicense.jsp"; 
	}
	
	@PostMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newlicense.jsp"; 
		}this.dlService.createLicense(license);
		return "redirect:/"; 
	}
	
	@GetMapping("/persons/{id}")
	public String findPerson(@PathVariable("id")Long id, Model model) {
		model.addAttribute("person", this.dlService.getPerson(id));
		return "showperson.jsp"; 
	}
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable("id")Long id) {
		this.dlService.deleteById(id);
		return "redirect:/"; 
	}
	
	


	
}
