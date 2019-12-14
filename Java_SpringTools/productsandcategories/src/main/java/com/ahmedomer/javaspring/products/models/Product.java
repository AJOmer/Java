package com.ahmedomer.javaspring.products.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
@SuppressWarnings("deprecation")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Size(min=2, max=15)
	private String name;
	@Size(min=4, max= 50)
	private String description;
	private double price;
	@Column(updatable=false)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(
			name = "categories_products",
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns = @JoinColumn(name="category_id")
	)
	private List<Category> categories;

	public Product() {
		
	}
	
	public Product(long id, String name, String description, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	@Required
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	@Required
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Category> getCategories() {
		return categories;
	}	
}
