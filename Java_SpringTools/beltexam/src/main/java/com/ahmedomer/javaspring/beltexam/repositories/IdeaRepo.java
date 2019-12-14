package com.ahmedomer.javaspring.beltexam.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedomer.javaspring.beltexam.models.Idea;

@Repository
public interface IdeaRepo extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
}
