package com.codingdojo.javaspring.pokemon;

public abstract class AbstractPokemon implements PokemonInterface{
	public Pokemon createPokemon(String name, int health, String type) {
		return new Pokemon();
	}
	public void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(-10);
		}
	}
                                                                                                                                
