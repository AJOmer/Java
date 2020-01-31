package com.ahmedomer.javaspring.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedomer.javaspring.javaproject.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long>{
	
}



