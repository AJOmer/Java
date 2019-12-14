package com.ahmedomer.javaspring.dojos;

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

import com.ahmedomer.javaspring.dojos.models.Dojo;
import com.ahmedomer.javaspring.dojos.models.Ninja;
import com.ahmedomer.javaspring.dojos.services.DojoService;
import com.ahmedomer.javaspring.dojos.services.NinjaService;


@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	////ROUTES\\\
	@RequestMapping("/ninjas/new")
	public String ninjaIndex(@ModelAttribute("myNinjaObject")Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojo", dojos);
		model.addAttribute("myNinja", ninjaService.allNinjas());
		return "/dojos/newninja.jsp";
	}
	@RequestMapping(value = "/addNinja", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("myNinja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/newninja.jsp";
		}
		else {
			ninjaService.newNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
