package com.codingdojo.springjava.objectmaster2;

public class Human {
	public int strength = 3;
	public int stealth = 3;
	public int intelligence = 3;
	public int health = 100;
	
	public Human () {
		
	}
	public void attack(Human human) {
		human.health = human.health-this.strength;
		System.out.println("Your health is now "+ human.health);
	}
}
