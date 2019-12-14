package com.ahmedomer.javaspring.relationships;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.ahmedomer.javaspring.relationships.models.License;
import com.ahmedomer.javaspring.relationships.models.Person;
import com.ahmedomer.javaspring.relationships.services.LicenseService;
import com.ahmedomer.javaspring.relationships.services.PersonService;

@Controller
public class LicenseController {
	
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public LicenseController(PersonService personService, LicenseService licenseService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	////ROUTES\\\
	@RequestMapping("/license/new")
	public String licenseApp(@ModelAttribute("myLicenseObject")License license, Model model) {
		List<Person> peeps = personService.allPersons();
		model.addAttribute("people", peeps);
		ArrayList<String> states = new ArrayList<String>(Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
				"Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
				"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
				"Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
				"Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"));
		model.addAttribute("states", states);
		return "/relationships/newdl.jsp";
	}
	@RequestMapping(value="/newdl", method=RequestMethod.POST)
	public String newLicense(@Valid @ModelAttribute("myLicenseObject")License license, BindingResult result) {
		if(result.hasErrors()) {
			return "/relationships/newdl.jsp";
		}
		else {
			String number = licenseService.generateLicenseNumber();
			license.setNumber(number);
			licenseService.generateLicenseNumber();
			licenseService.createLicense(license);
			return "redirect:/persons/"+ license.getId();
		}
	}
}
