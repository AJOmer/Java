package com.ahmedomer.javaspring.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedomer.javaspring.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findTopByOrderByNumberDesc();
}
