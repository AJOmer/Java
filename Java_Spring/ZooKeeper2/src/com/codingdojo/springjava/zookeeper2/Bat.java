package com.codingdojo.springjava.zookeeper2;

public class Bat extends Mammal {
	
	public Bat () {
		this.energyLevel = 300;
	}
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("WOOOOSSHHH");
		this.displayEnergy();
	}
	public void eatHumans() {
		this.energyLevel += 25;
		this.displayEnergy();
	}
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("ARGGGGHHH");
		this.displayEnergy();
	}
}
