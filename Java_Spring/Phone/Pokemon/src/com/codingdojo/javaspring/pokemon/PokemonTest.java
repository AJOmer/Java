package com.codingdojo.javaspring.pokemon;

public class PokemonTest extends PokeDex {
	public static void main(String[] args) {
		PokeDex pokedex = new PokeDex();
		
		Pokemon mews = pokedex.createPokemon("Mews", 200, "Unknown");
		Pokemon houndDog = pokedex.createPokemon("HoundDog", 100, "Canine");
		
		pokedex.attackPokemon(mews);
		pokedex.attackPokemon(houndDog);
		pokedex.pokemonInfo(houndDog);
		pokedex.pokemonInfo(mews);
	}
}
