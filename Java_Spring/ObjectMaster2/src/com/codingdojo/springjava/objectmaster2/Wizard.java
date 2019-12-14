package com.codingdojo.springjava.objectmaster2;

public class Wizard extends Human {
	
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	public void heal(Human human) {
		human.health = human.health + this.stealth;
		System.out.println("Health is now: " + human.health);
	}
	public void fireball(Human human) {
		human.health = human.health - (this.intelligence*3);
		System.out.println("The health is now: " + human.health);
	}
}
