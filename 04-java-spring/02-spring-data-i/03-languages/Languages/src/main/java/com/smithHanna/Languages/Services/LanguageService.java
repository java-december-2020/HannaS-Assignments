package com.smithHanna.Languages.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smithHanna.Languages.Models.Language;
import com.smithHanna.Languages.Repositories.LanguageRepository;

@Service
public class LanguageService {

	private LanguageRepository langRepo; 
	
	public LanguageService(LanguageRepository langRepository) {
		langRepo = langRepository; 
	}
	
	public List<Language> findAllLanguages(){
		return this.langRepo.findAll();
	}
	
	public Language createLanguage(Language newLanguage) {
		return this.langRepo.save(newLanguage);
	}
	
	public Language getLanguageById(Long id) {
		return this.langRepo.findById(id).orElse(null);
	}
	
	public Language updateLanguage(Language updatedLanguage) {
		return this.langRepo.save(updatedLanguage);
	}
	
	public void deleteLanguage(Long id) {
		this.langRepo.deleteById(id);
	}
}
