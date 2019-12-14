package com.codingdojo.springjava.zookeeper1;

public class Mammal {
	int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println("Energy level is: " + energyLevel);
		return energyLevel;
	}
}
