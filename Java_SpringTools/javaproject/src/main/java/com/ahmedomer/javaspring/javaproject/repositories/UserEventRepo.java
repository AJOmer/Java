package com.ahmedomer.javaspring.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedomer.javaspring.javaproject.models.UserEvent;

@Repository
public interface UserEventRepo extends CrudRepository <UserEvent, Long> {

}
