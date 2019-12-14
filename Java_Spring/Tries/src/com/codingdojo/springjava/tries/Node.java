package com.codingdojo.springjava.tries;
import java.util.HashMap;
public class Node {
	public HashMap<Character, Node> children;
	public boolean isCompleted;
	
	public Node() {
		this.children = new HashMap<Character, Node>();
		this.isCompleted = false;
	}
}
