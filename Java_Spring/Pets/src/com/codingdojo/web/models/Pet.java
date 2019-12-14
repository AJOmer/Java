package com.codingdojo.web.models;

public interface Pet {
	public default String showAffection() {
		return "showing love to the owner";
	}
}
