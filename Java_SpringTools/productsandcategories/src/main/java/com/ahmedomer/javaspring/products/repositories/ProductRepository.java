package com.ahmedomer.javaspring.products.repositories;

import java.util.List;
import java.util.Iterator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmedomer.javaspring.products.models.Category;
import com.ahmedomer.javaspring.products.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Iterator<Product> findByCategoriesNotContains(Category category);
}
