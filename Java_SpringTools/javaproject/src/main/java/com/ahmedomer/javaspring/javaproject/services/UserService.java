package com.ahmedomer.javaspring.javaproject.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.javaproject.models.Event;
import com.ahmedomer.javaspring.javaproject.models.Message;
import com.ahmedomer.javaspring.javaproject.models.User;
import com.ahmedomer.javaspring.javaproject.repositories.EventRepo;
import com.ahmedomer.javaspring.javaproject.repositories.MessageRepo;
import com.ahmedomer.javaspring.javaproject.repositories.UserEventRepo;
import com.ahmedomer.javaspring.javaproject.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final MessageRepo messageRepo;
	private final UserEventRepo userEventRepo;
	private final EventRepo eventRepo;
	
	public UserService(UserRepository userRepository, MessageRepo messageRepo, UserEventRepo userEventRepo, EventRepo eventRepo) {
		this.userRepository = userRepository;
		this.messageRepo = messageRepo;
		this.userEventRepo = userEventRepo;
		this.eventRepo = eventRepo;
	}
	///delete an event\\
	public void deleteEvent(long id) {
		eventRepo.deleteById(id);
	}
	//find all events\\\
	public List<Event> allEvents(){
		return (List<Event>) eventRepo.findAll();
	}
	///add an event\\
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	///find event by id\\
	public Event findEventById(long id) {
		Optional<Event> e = eventRepo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		else {
			return null;
		}
	}
	///update event\\
	public void updateEvent(Event event) {
		eventRepo.save(event);
	}
	//update user\\
	public void updateUser(User user) {
		userRepository.save(user);
	}
	////Registration\\\
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
	///find by email\\\
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	///find by a user's id\\
	public User findByUserId(long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
	///Authentication/Login\\\
	public boolean authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	///checks to see if its an already used email\\\
	public boolean duplicateUser(String email) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			return true;
		}
	}
	///Return all messages\\\
	public List<Message> allMess(){
		return (List<Message>) messageRepo.findAll();
	}
	///add a message\\\
	public Message addMessage(Message message) {
		return messageRepo.save(message);
	}
	///find a message\\\
	public Message myMessage(long id) {
		Optional<Message> optionalMess = messageRepo.findById(id);
		if(optionalMess.isPresent()) {
			return optionalMess.get();
		}
		else {
			return null;
		}
	}
	///update a message\\\
	public void updateMess(Message messages) {
		messageRepo.save(messages);
//		return messages;
	}
	public void newMessage(Message message) {
		messageRepo.save(message);
	}
	////delete a message\\\
//	public void deleteMess(long id) {
//		this.messageRepo.deleteById(id);
//	}
}
