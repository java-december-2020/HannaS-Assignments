package com.smithHanna.DojosandNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.DojosandNinjas.models.Dojo;
import com.smithHanna.DojosandNinjas.models.Ninja;
import com.smithHanna.DojosandNinjas.repositories.DojoRepository;
import com.smithHanna.DojosandNinjas.repositories.NinjaRepository;

@Service
public class NinjaDojoService {
	@Autowired
	private NinjaRepository nRepo; 
	@Autowired
	private DojoRepository dRepo; 
	
	public NinjaDojoService() {
		
	}
	
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	
	public Ninja findNinjaById(Long id){
		return this.nRepo.findById(id).orElse(null);
	}
	
	public List<Ninja> getAllNinjas(){
		return this.nRepo.findAll();
	}
	
	public List<Dojo> findAllDojos(){
		return this.dRepo.findAll(); 
	}
	public Dojo findDojoById(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	public Dojo createDojo(Dojo dojo) {
		return this.dRepo.save(dojo); 
	}
	

 	
	
	
}
