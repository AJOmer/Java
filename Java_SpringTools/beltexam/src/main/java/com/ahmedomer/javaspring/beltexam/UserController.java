package com.ahmedomer.javaspring.beltexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmedomer.javaspring.beltexam.models.Idea;
import com.ahmedomer.javaspring.beltexam.models.User;
import com.ahmedomer.javaspring.beltexam.services.UserService;
import com.ahmedomer.javaspring.beltexam.validators.UserValidator;

@Controller
public class UserController {
	private final UserValidator userValidator;
	private final UserService userService;
	
	public UserController(UserValidator userValidator, UserService userService) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("userObj")User user, Model model) {
		return "/belt/index.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("userObj") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "/belt/index.jsp";
		}
		boolean isDuplicate = userService.duplicateUser(user.getEmail());
		if(isDuplicate) {
			model.addAttribute("error", "Email already in use! Intruder!!");
			return "/belt/index.jsp";
		}
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/dashboard";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("userObj") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("error", "Invalid credentials");
			return "/belt/index.jsp";
		}
	}
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

	@GetMapping("/idea/new")
	public String newIdea(@ModelAttribute("ideaObj")Idea idea, Model model) {
		return "/belt/newidea.jsp";
	}
	@RequestMapping(value="/newIdeas", method=RequestMethod.POST)
	public String addIdea(@Valid @ModelAttribute("ideaObj")Idea idea, BindingResult result) {
		if(result.hasErrors()) {
			return "/belt/newidea.jsp";
		}
		else {
			userService.newIdea(idea);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/dashboard")
	public String dash(@ModelAttribute("myObj")Idea idea, Model model) {
		List<Idea> ideal = userService.allIdeas();
		model.addAttribute("ideas", ideal);
		return "/belt/dashboard.jsp";
	}
	@RequestMapping("/idea/{id}")
	public String showIdea(@PathVariable("id") long id, Model model) {
		Idea theIdea = userService.myIdea(id);
		model.addAttribute("thisIdea", theIdea);
		return "/belt/show.jsp";
	}
	@RequestMapping("/idea/{id}/edit")
	public String editPage(@PathVariable("id")long id, Model model) {
		Idea flIdea = userService.myIdea(id);
		model.addAttribute("thisIdea", flIdea);
		return "/belt/update.jsp";
	}
	@RequestMapping(value="/idea/{id}/edit", method= RequestMethod.PUT)
	public String updateIdea(@Valid @ModelAttribute("thisIdea")Idea myidea, BindingResult result, @PathVariable("id")long id) {
		if(result.hasErrors()) {
			return "redirect:/idea/"+id+"/edit";
		}
		else {
			Idea oneIdea = userService.myIdea(id);
			oneIdea.setIdea(myidea.getIdea());
			userService.updateIdea(oneIdea);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping(value="/idea/{id}/delete")
	public String destroy(@PathVariable("id")long id) {
		userService.deleteIdea(id);
		return "redirect:/dashboard";
	}
}
