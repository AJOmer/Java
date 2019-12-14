package com.codingdojo.springjava.objectmaster1;

public class Human {
	private int strength = 3;
	private int stealth = 3;
	private int intelligence = 3;
	private int health = 100;
	
	public Human () {
		
	}
	public void attack(Human human) {
		human.health = human.health-this.strength;
		System.out.println("Your health is now "+ human.health);
	}
}
