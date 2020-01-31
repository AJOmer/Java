package com.ahmedomer.javaspring.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedomer.javaspring.javaproject.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {

}
