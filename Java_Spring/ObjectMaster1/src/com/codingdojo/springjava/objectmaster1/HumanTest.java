package com.codingdojo.springjava.objectmaster1;

public class HumanTest {
	public static void main(String[] args) {
		Human noah = new Human();
		Human nick = new Human();
		
		noah.attack(nick);
		nick.attack(noah);
		nick.attack(noah);
	}
}
