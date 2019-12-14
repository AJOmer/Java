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
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	///ROUTES\\\
	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("dojoObject")Dojo dojo, Model model) {
//		model.addAttribute("dojoObject", dojoService.allDojos());
		return "/dojos/index.jsp";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojoObject")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/index.jsp";
		}
		else {
			dojoService.newDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String findDojo(@PathVariable("id")long id, Model model) {
		Dojo dojo = dojoService.myDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojos/show.jsp";
	}
}



