package com.ahmedomer.javaspring.products.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.products.models.Category;
import com.ahmedomer.javaspring.products.models.Product;
import com.ahmedomer.javaspring.products.repositories.CategoryRepository;
//import com.ahmedomer.javaspring.products.repositories.ProductCategoryRepo;
import com.ahmedomer.javaspring.products.repositories.ProductRepository;
//import com.ahmedomer.javaspring.products.models.CategoryProduct;


@Service
public class CategoryProductService {
	@Autowired
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
//	private final ProductCategoryRepo productCategoryRepo;
	
	public CategoryProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
//		this.productCategoryRepo = productCategoryRepo;
	}
	////return all products\\\
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	///add a product\\\
	public Product newProduct(Product prod) {
		return productRepository.save(prod);
	}
	///Return all categories\\\
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	///Add a category\\\
	public Category addCat(Category cat) {
		return categoryRepository.save(cat);
	}
	///find a product\\\
	public Product findProduct(long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	///find a category\\\
	public Category findCat(long id) {
		Optional<Category> optionalCat = categoryRepository.findById(id);
		if(optionalCat.isPresent()) {
			return optionalCat.get();
		}
		else {
			return null;
		}
	}
	public void update(Category category) {
		category.setUpdatedAt(new Date());
		categoryRepository.save(category);
	}
	
	///figure out proper SQL queries to set in repository\\\
	
	////add category to product\\\
//	public void addCatToProd(CategoryProduct catToProd) {
//		productCategoryRepo.save(catToProd);
//	}
	///availiable products for category\\
//	public Iterator<Product> availableProductsForCategories(Category category){
//		return productRepository.findByCategoriesNotContains(category);
//	}
	////add product to category\\\
//	public void addProdtoCat(CategoryProduct categoryProduct) {
//		productCategoryRepo.save(categoryProduct);
//	}
	///update a category\\\

	///available categories for product\\\
//	public Iterator<Category> availableCategoriesForProducts(Product product) {
//		return categoryRepository.findByProductsNotContains(product);
//	}
}
