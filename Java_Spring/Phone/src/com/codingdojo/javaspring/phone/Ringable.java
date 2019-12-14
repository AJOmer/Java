package com.codingdojo.javaspring.phone;

public interface Ringable {
	public default String ring() {
		return "bzzzZZzz";
	}
	public default String unlock() {
		return"click click click click";
	}
}
