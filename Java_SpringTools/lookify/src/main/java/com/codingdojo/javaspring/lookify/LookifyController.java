package com.codingdojo.javaspring.lookify;

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

import com.codingdojo.javaspring.lookify.models.Lookify;
import com.codingdojo.javaspring.lookify.services.LookifyService;


@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	////ROUTES\\\
	@RequestMapping("/")
	public String index(Model model) {
		return "/lookify/index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dash(Model model) {
		List<Lookify> songs = lookifyService.allSongs();
		model.addAttribute("lookify", songs);
		return "/lookify/show.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("lookify")Lookify slap, Model model) {
		return "/lookify/new.jsp";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("lookify")Lookify newSlap, BindingResult result) {
		if(result.hasErrors()) {
			return"/lookify/new.jsp";
		}
		else {
			lookifyService.createSong(newSlap);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{id}")
	public String showSong(@PathVariable("id") long id, Model model) {
		Lookify look = lookifyService.findSong(id);
		model.addAttribute("lookify", look);
		return "/lookify/info.jsp";
	}
	@RequestMapping(value ="/songs/{id}/delete")
	public String destroy(@PathVariable("id") long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/search/topTen")
	public String tenHits(Model model) {
		List<Lookify> songs = lookifyService.getTopTen();
		model.addAttribute("songs", songs);
		return "/lookify/topten.jsp";
	}
	@RequestMapping("/search/{artist}")
	public String artistSearch(@PathVariable("artist")String artist, Model model) {
		List<Lookify> songs = lookifyService.getArtistSongs(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "/lookify/search.jsp";
	}
	@PostMapping("/search")
	public String search(@RequestParam("artist")String artist) {
		return"redirect:/search/"+artist;
	}
}
