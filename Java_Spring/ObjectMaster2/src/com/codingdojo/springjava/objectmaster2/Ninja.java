package com.codingdojo.springjava.objectmaster2;

public class Ninja extends Human {
	
	public Ninja() {
		this.stealth = 10;
	}
	public void steal(Human human) {
		human.health = human.health - this.stealth;
		this.health = this.health + this.stealth; 
		System.out.println("Your health is now: "+ this.health);
	}
	public void runAway() {
		this.health -= 10;
		System.out.println("Stop being a coward");
	}
}
