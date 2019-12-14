package com.codingdojo.javaspring.pokemon;

public class Pokemon {
	private String name;
	private int health;
	private String type;
	private static int pokeCount = 0;
	
	public Pokemon() {
		String name = getName();
		int health = 100;
		String type = getType();
		pokeCount ++;
	}
	///getters
	
	public String getName() {
		return this.name;
	}
	public int getHealth() {
		return this.health;
	}
	public String getType() {
		return this.type;
	}
	///setters
	public void setName(String name) {
		this.name = name;
	}
	public void setHealth(int health) {
		this.health += health;
	}
	public void setType(String type) {
		this.type = type;
	}
//	void attackPokemon(Pokemon pokemon) {
//		pokemon.health -= 10;
//	}
}

