package com.ahmedomer.javaspring.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.relationships.models.Person;
import com.ahmedomer.javaspring.relationships.repositories.PersonRepository;


@Service
public class PersonService {
	@Autowired
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	///return all persons\\\
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	///create a person\\\
	public Person createPerson(Person peep) {
		return personRepository.save(peep);
	}
	///retrieve person\\\
	public Person findPerson(long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
}
