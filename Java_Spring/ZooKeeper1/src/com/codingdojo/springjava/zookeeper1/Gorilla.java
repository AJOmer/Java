package com.codingdojo.springjava.zookeeper1;

public class Gorilla extends Mammal {
	public void throwSomething() {
		energyLevel -= 5;
		System.out.println("Energy level is: " + energyLevel);
//		displayEnergy();
	}
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println("Very happy with the bananas");
		this.displayEnergy();
	}
	public void climb() {
		this.energyLevel -= 10;
		System.out.println("Very tiring stuff");
		this.displayEnergy();
	}
}
