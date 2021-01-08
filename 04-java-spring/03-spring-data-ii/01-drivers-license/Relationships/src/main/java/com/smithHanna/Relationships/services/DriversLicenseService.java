package com.smithHanna.Relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smithHanna.Relationships.models.License;
import com.smithHanna.Relationships.models.Person;
import com.smithHanna.Relationships.repositories.LicenseRepository;
import com.smithHanna.Relationships.repositories.PersonRepository;
@Service
public class DriversLicenseService {

	
	private PersonRepository pRepo; 
	private LicenseRepository lRepo; 
	public DriversLicenseService(PersonRepository pRepository, LicenseRepository lRepository) {
		this.pRepo = pRepository; 
		this.lRepo = lRepository; 
	}

	
	public Person getPerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Person> getAllPeople() {
		return this.pRepo.findAll();
	}
	
	public List<Person> getUnlicensed(){
		return this.pRepo.findByNoLicense();
	}
	
	public List<License> getLicenseInfo(){
		return this.lRepo.findAll();
	}
	
	public License getLicense(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	public License createLicense(License newLicense) {
		newLicense.setNumber(this.generateLicenseNum());
		return this.lRepo.save(newLicense);
	}
	
	public int generateLicenseNum() {
		License license = this.lRepo.findTopByOrderByIdDesc();
		if(license == null)
			return 1; 
		int largestNum = license.getNumber();
		largestNum++;
		return largestNum;
	}
	public void deleteById(Long id) {
		this.pRepo.deleteById(id);
	}
}
