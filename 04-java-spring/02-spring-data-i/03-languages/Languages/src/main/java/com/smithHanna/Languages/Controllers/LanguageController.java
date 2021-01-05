package com.smithHanna.Languages.Controllers;

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

import com.smithHanna.Languages.Models.Language;
import com.smithHanna.Languages.Services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	
	private LanguageService lService; 
	public LanguageController(LanguageService service) {
		lService = service; 
	}
	
	@GetMapping("")
	public String index(Model model) {
	List<Language> allLangs = this.lService.findAllLanguages(); 
	model.addAttribute("allLangs", allLangs);
	model.addAttribute("language", new Language());
	return "index2.jsp"; 
	}
	
	@PostMapping("")
	public String createLang(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> AllLang = this.lService.findAllLanguages();
			model.addAttribute("allLang", AllLang);
			return "index2.jsp";
		}
		this.lService.createLanguage(language);
		return "redirect:/languages";
	}
	@GetMapping("/{id}")
	public String findLanguage(@PathVariable("id") Long id, Model model) {
		Language findLang =this.lService.getLanguageById(id);
		model.addAttribute("lang", findLang);
		return "name.jsp"; 
	}
	@GetMapping("/edit/{id}")
	public String editLang(@PathVariable("id")Long id, Model model) {
		Language editLang = this.lService.getLanguageById(id);
		model.addAttribute("language", editLang);
		model.addAttribute("lang", editLang);
		return "edit.jsp"; 
	}
	
	@PostMapping("/edit/{id}")
	public String updateLang(@Valid @ModelAttribute("language") Language language, BindingResult result1, Model model,@PathVariable("id")Long id, @RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("version")String version) {
		if(result1.hasErrors()) {
		return "edit.jsp";
		}
		Language updateLanguage = this.lService.getLanguageById(id);
		updateLanguage.setCreator(creator);
		updateLanguage.setName(name);
		updateLanguage.setVersion(version);
		this.lService.updateLanguage(updateLanguage);
		model.addAttribute("language", updateLanguage);
		return "redirect:/languages";
	}
	@GetMapping("/delete/{id}")
	public String deleteLang(@PathVariable("id")Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/languages"; 
	}
}

