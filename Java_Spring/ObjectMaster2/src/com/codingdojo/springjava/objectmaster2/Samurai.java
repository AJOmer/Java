package com.codingdojo.springjava.objectmaster2;

public class Samurai extends Human{
	public int samuraiCount;
	public Samurai() {
		this.health = 200;
		samuraiCount += 1;
		
	}
	public void deathBlow(Human human) {
		human.health = human.health-human.health;
		this.health = this.health/2;
		System.out.println("Your health after the blow is: "+ this.health);
	}
	public void meditate() {
		this.health = this.health*2;
		System.out.println("Health went back up to: "+ this.health);
	}
	public int howMany() {
		System.out.println(samuraiCount);
		return samuraiCount;
	}
}
