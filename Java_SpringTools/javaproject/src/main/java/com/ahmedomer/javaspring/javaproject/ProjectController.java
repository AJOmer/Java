package com.ahmedomer.javaspring.javaproject;

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

import com.ahmedomer.javaspring.javaproject.models.Event;
import com.ahmedomer.javaspring.javaproject.models.Message;
import com.ahmedomer.javaspring.javaproject.models.User;
import com.ahmedomer.javaspring.javaproject.services.UserService;
import com.ahmedomer.javaspring.javaproject.validators.UserValidator;

@Controller
public class ProjectController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public ProjectController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	ArrayList<String> states = new ArrayList<String>(Arrays.asList("", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
	
	@RequestMapping("/")
	public String index(@ModelAttribute("userObj")User user, Model model) {
		model.addAttribute("states", states);
		return "/project/index.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("userObj") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "/project/index.jsp";
		}
		boolean isDuplicate = userService.duplicateUser(user.getEmail());
		if(isDuplicate) {
			model.addAttribute("error", "Email already in use");
			return "/project/index.jsp";
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
			return "/project/index.jsp";
		}
	}
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    @RequestMapping("/dashboard")
    public String dash(@Valid @ModelAttribute("eventObj")Event event, BindingResult result, HttpSession session, Model model) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findByUserId(userId);
    	model.addAttribute("user", user);
    	session.setAttribute("states", states);
    	List<Event> events = userService.allEvents();
    	List<Event> instate = new ArrayList<Event>();
    	List<Event> outofstate = new ArrayList<Event>();
    	for(Event origin: events) {
    		if(origin.getState().equals(user.getState())) {
    			instate.add(origin);
    		}
    		else {
    			outofstate.add(origin);
    		}
    	}
    	model.addAttribute("instate", instate);
    	model.addAttribute("outofstate", outofstate);
    	return "/project/landing.jsp";
    } 
    @RequestMapping("/events/{id}")
    public String viewEvent(@PathVariable("id") long id, @Valid @ModelAttribute("messageObj") Message message, BindingResult result, HttpSession session, Model model) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findByUserId(userId);
    	Event event = userService.findEventById(id);
    	List<Message> messages = event.getMessages();
    	Collections.reverse(messages);
    	model.addAttribute("messages", messages);
    	model.addAttribute("user", user);
    	model.addAttribute("event", event);
    	model.addAttribute("attendees", event.getJoinedUsers());
    	return "/project/dashboard.jsp";
    }
    @RequestMapping("/events/{id}/edit")
    public String editPage(@PathVariable("id") long id, @ModelAttribute("eventObj") Event event, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findByUserId(userId);
    	if(userService.findEventById(id).getUser().getId() == user.getId()) {
    		model.addAttribute("event", userService.findEventById(id));
    		return "/project/edit.jsp";
    	}
    	else {
    		model.addAttribute("error", "Invalid Credentials, not event creator");
    		return "redirect:/dashboard";
    	}
    }
    
    
    @PostMapping("/addevent")
    public String newevent(@Valid @ModelAttribute("eventObj") Event event, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		System.out.println("error");
    		return "/project/dashboard.jsp";
    	}
    	else {
    		userService.addEvent(event);
    		return "redirect:/dashboard";
    	}
    }
    @PutMapping("/events/{id}/edit")
    public String editEvent(@Valid @PathVariable("id") long id, @ModelAttribute("eventObj") Event event, BindingResult result, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findByUserId(userId);
    	if(userService.findEventById(id).getUser().getId() == user.getId()) {
    		if(result.hasErrors()) {
    			model.addAttribute("event", userService.findEventById(id));
    			return "/project/edit.jsp";
    		}
    		else {
    			Event eventEdit = userService.findEventById(id);
    			event.setUser(user);
    			event.setJoinedUsers(event.getJoinedUsers());
    			userService.updateEvent(event);
    			model.addAttribute("event", eventEdit);
    			model.addAttribute("user", user);
    			return "redirect:/dashboard";
    		}
    	}
    	else {
    		return "redirect:/";
    	}
    }
   @RequestMapping("/events/{id}/join")
   public String joinevent(@PathVariable("id") long id, HttpSession session) {
   	Long userId = (Long) session.getAttribute("userId");
   	User user = userService.findByUserId(userId);
   	Event event = userService.findEventById(id);
   	List<User> attendees = event.getJoinedUsers();
   	attendees.add(user);
   	event.setJoinedUsers(attendees);
   	userService.updateUser(user);
   	System.out.println("JOINING");
   	return "redirect:/dashboard";
   }
   @RequestMapping("/events/{id}/cancel")
   public String cancelEvent(@PathVariable("id") long id, HttpSession session) {
   	Long userId = (Long) session.getAttribute("userId");
   	User user = userService.findByUserId(userId);
   	Event event =userService.findEventById(id);
   	List<User> attendees = event.getJoinedUsers();
   	for(int i = 0; i< attendees.size();i++) {
   		if(attendees.get(i).getId() == user.getId()) {
   			attendees.remove(i);
   		}
   	}
   	event.setJoinedUsers(attendees);
   	userService.updateUser(user);
   	return "redirect:/dashboard";
   }
   @RequestMapping("/events/{id}/delete")
   public String deleteEvent(@PathVariable("id") long id) {
	   Event event = userService.findEventById(id);
	   for(User user: event.getJoinedUsers()) {
		   List<Event> myevents = user.getJoinedevents();
		   myevents.remove(event);
		   user.setJoinedevents(myevents);
		   userService.updateUser(user);
	   }
	   userService.deleteEvent(id);
	   return "redirect:/dashboard";
   }
   @PostMapping("/events/addmsg")
   public String addMsg(@ModelAttribute("messageObj") Message message, BindingResult result, Model model, HttpSession session) {
   	Long userId = (Long) session.getAttribute("userId");
   	User user = userService.findByUserId(userId);
   	model.addAttribute("user", user);
   	userService.addMessage(message);
   	return "redirect:/dashboard";
   }
}
