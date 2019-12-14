package com.codingdojo.javaspring.languages;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.javaspring.languages.models.Languages;
import com.codingdojo.javaspring.languages.services.LanguageService;


@Controller
public class LanguagesController {
	///adding languageService as a dependency\\\
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Languages> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		model.addAttribute("newLang", new Languages());
		return "/languages/index.jsp";
	}
	@RequestMapping(value = "/languages", method=RequestMethod.POST)
	public String createLanguage(@Valid @ModelAttribute("languages")Languages newLang, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages";
		}
		else {
			languageService.createLanguage(newLang);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/{id}")
	public String showLanguage(@PathVariable("id")long id, Model model) {
		Languages lang = languageService.findLanguage(id);
		model.addAttribute("languages", lang);
		return "/languages/show.jsp";
	}
	@RequestMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id")long id, Model model) {
		Languages lang = languageService.findLanguage(id);
		model.addAttribute("languages", lang);
		return "/languages/edit.jsp";
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
		public String updateLang(@Valid @ModelAttribute("languages")Languages languages, BindingResult result) {
			if(result.hasErrors()) {
				return "/languages/edit.jsp";
			}
			else {
				languageService.updateLanguage(languages);
				return "redirect:/languages";
			}
		}
	@RequestMapping(value = "/languages/{id}/delete")
	public String destroy(@PathVariable("id")Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	}
