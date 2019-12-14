package com.ahmedomer.javaspring.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.beltexam.models.Idea;
import com.ahmedomer.javaspring.beltexam.models.User;
import com.ahmedomer.javaspring.beltexam.repositories.IdeaRepo;
import com.ahmedomer.javaspring.beltexam.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo userRepo;
	private final IdeaRepo ideaRepo;
	
	public UserService(UserRepo userRepo, IdeaRepo ideaRepo) {
		this.userRepo = userRepo;
		this.ideaRepo = ideaRepo;
	}
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	public User findByUserId(long id) {
		Optional<User> yoo = userRepo.findById(id);
		if(yoo.isPresent()) {
			return yoo.get();
		}
		else {
			return null;
		}
	}
	////authentication\\\
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
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
	public boolean duplicateUser(String email) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			return true;
		}
	}
	///Return all ideas\\\\
	public List<Idea> allIdeas(){
		return ideaRepo.findAll();
	}
	///add a idea\\\
	public Idea newIdea(Idea idea) {
		return ideaRepo.save(idea);
	}
	///find a idea\\\
	public Idea myIdea(long id) {
		Optional<Idea> optionalIdea = ideaRepo.findById(id);
		if(optionalIdea.isPresent()) {
			return optionalIdea.get();
		}
		else {
			return null;
		}
	}
	///update an idea\\\
	public Idea updateIdea(Idea ideas) {
		ideaRepo.save(ideas);
		return ideas;
	}
	///delete and idea\\\
	public void deleteIdea(long id) {
		this.ideaRepo.deleteById(id);
	}
}
