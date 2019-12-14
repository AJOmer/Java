package com.codingdojo.web.models;

public class Cat extends Animal implements Pet {
	public Cat(String name, String breed, double weight) {
		super(name, breed, weight);
	}
	@Override
	public String showAffection() {
		return "Your cat "+ this.getName() + "which is a "+ this.getBreed()+ "looked at you with affection. we think";
	}
}
