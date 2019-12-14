package com.codingdojo.javaspring.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.javaspring.languages.models.Languages;
import com.codingdojo.javaspring.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	///adding language repository as a dependency\\\
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	///returns all languages\\
	public List<Languages> allLanguages(){
		return languageRepository.findAll();
	}
	///create new language\\
	public Languages createLanguage(Languages l) {
		return languageRepository.save(l);
	}
	////retrieve a language\\\
	public Languages findLanguage(long id) {
		Optional<Languages> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	///update a language\\\
	public Languages updateLanguage(Languages l) {
		return languageRepository.save(l);
	}
	////deletes a language\\\
	public void deleteLanguage(long id) {
		this.languageRepository.deleteById(id);
	}
}

