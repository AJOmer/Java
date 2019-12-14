package com.ahmedomer.javaspring.relationships;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmedomer.javaspring.relationships.models.Person;
import com.ahmedomer.javaspring.relationships.services.LicenseService;
import com.ahmedomer.javaspring.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	///ROUTESSS\\
	@RequestMapping("/persons/new")
	public String index(@ModelAttribute("myPerson") Person peep, Model model) {
		return "/relationships/index.jsp";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("myPerson")Person peep, BindingResult result) {
		if(result.hasErrors()) {
			return"/relationships/index.jsp";
		}
		else {
			personService.createPerson(peep);
			return"redirect:/persons/new";
		}
	}
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id")long id, Model model) {
		model.addAttribute("license", licenseService.findLicense(id).getPerson());
		return "/relationships/show.jsp";
	}
}
