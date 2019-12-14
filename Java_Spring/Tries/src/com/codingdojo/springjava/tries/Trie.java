package com.codingdojo.springjava.tries;

public class Trie {
	public Node root;
	
	public Trie() {
		this.root = new Node();
	}
	public void insertWord(String word) {
		Node currentNode = this.root;
		for(int i = 0; i < word.length(); i++) {
			char currentLetter = word.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				child = new Node();
				currentNode.children.put(currentLetter, child);
			}
			currentNode = child;
		}
		currentNode.isCompleted = true;
	}
	public boolean isPrefixValid(String prefix) {
		Node currentNode = this.root;
		for(int i = 0; i < prefix.length(); i++) {
			char currentLetter = prefix.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			if(currentNode.children.get(currentLetter) != null ) {
				currentNode = currentNode.children.get(currentLetter);
			}
			else {
				return false;
			}
		}
		return true;
	}
	public boolean isWordValid(String word) {
		Node currentNode = this.root;
		for(int i = 0; i < word.length();i++) {
			char currentLetter = word.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			if(currentNode.children.get(currentLetter) != null) {
				currentNode = currentNode.children.get(currentLetter);
			}
			else {
				return false;
			}
		}
		return true;
	}
//	public void printAllKeys() {
//		Node runner = this.root;
//		while(runner != null) {
//			System.out.println(runner.value);
//			runner=runner.next;
//		}
//	}
}
