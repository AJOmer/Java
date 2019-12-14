package com.ahmedomer.javaspring.login.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.login.models.User;
import com.ahmedomer.javaspring.login.repositories.UserRepository;


@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	////Register user and hash their password\\\
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
	////find a user by email\\\
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	///find user by ID\\
	public User findUserById(long id) {
		Optional<User> use = userRepository.findById(id);
		if(use.isPresent()) {
			return use.get();
		}
		else {
			return null;
		}
	}
	////authenticate user\\\\
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
}
