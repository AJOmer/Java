package com.codingdojo.springjava.objectmaster2;

public class HumanTest {
	
	public static void main(String[] args) {
		
		Human ed = new Human();
		Human lau = new Human();
		Human nick = new Human();
		
		Wizard wiz1 = new Wizard();
		Wizard wiz2 = new Wizard();
		Wizard wiz3 = new Wizard();
		
		Ninja nin1 = new Ninja();
		Ninja nin2 = new Ninja();
		Ninja nin3 = new Ninja();
		
		Samurai sam1 = new Samurai();
		Samurai sam2 = new Samurai();
		
		
		ed.attack(nick);
		ed.attack(nick);
		sam1.deathBlow(lau);
		nin2.runAway();
		wiz3.heal(nick);
		sam2.deathBlow(sam1);
		sam1.meditate();
		nin3.steal(ed);
		nin1.attack(wiz2);
		wiz1.heal(ed);
		
	}
}
