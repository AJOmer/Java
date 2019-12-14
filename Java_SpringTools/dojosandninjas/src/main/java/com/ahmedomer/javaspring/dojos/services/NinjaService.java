package com.ahmedomer.javaspring.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.dojos.models.Ninja;
import com.ahmedomer.javaspring.dojos.repositories.NinjaRepository;


@Service
public class NinjaService {
	@Autowired
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	////get all ninjas\\\
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	///create a ninja\\\
	public Ninja newNinja(Ninja nin) {
		return ninjaRepository.save(nin);
	}
	///find a ninja\\\
	public Ninja findNinja(long id) {
		Optional<Ninja> myNinja = ninjaRepository.findById(id);
		if(myNinja.isPresent()) {
			return myNinja.get();
		}
		else {
			return null;
		}
	}
}
