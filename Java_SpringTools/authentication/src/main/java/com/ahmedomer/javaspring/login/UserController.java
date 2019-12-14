package com.ahmedomer.javaspring.login;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmedomer.javaspring.login.models.User;
import com.ahmedomer.javaspring.login.services.UserService;
import com.ahmedomer.javaspring.login.validators.UserValidator;


@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	@GetMapping("/registration")
	public String registrationForm(@ModelAttribute("user")User user) {
		return "/login/registrationPage.jsp";
	}
	@GetMapping("/login")
	public String login() {
		return "/login/loginPage.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return"/login/registrationPage.jsp";
		}
		else {
			User u = userService.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "/login/loginPage.jsp";
		}
	}
	@PostMapping("/signin")
	public String loginUser(@RequestParam("email")String email, @RequestParam("password")String password, Model model, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "/login/homePage.jsp";
		}
		else {
			model.addAttribute("error", "Invalid Credentials!");
			return "redirect:/login";
		}
	}
	@GetMapping("/home")
	public String landing(HttpSession session, Model model) {
		long userId = (long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		model.addAttribute("user", u);
		return "/login/homePage.jsp";
	}
}
