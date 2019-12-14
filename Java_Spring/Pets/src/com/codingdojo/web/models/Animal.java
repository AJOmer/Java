package com.codingdojo.web.models;

public class Animal {
	private String name;
	private String breed;
	private double weight;
	
	public Animal(String name, String breed, double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	////getters
	public String getName() {
		return name;
	}
	public String getBreed() {
		return breed;
	}
	public double getWeight() {
		return weight;
	}
	///setters
	public void setName(String name) {
		this.name = name;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
