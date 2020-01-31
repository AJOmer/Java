package com.ahmedomer.javaspring.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedomer.javaspring.javaproject.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
