package com.ahmedomer.javaspring.dojos.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.dojos.models.Dojo;
import com.ahmedomer.javaspring.dojos.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	////returns all dojos\\
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	///add a dojo\\\
	public Dojo newDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	////find a dojo\\\
	public Dojo myDojo(long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
}
