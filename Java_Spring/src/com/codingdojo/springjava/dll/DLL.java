package com.codingdojo.springjava.dll;

public class DLL {
	public Node head;
	public Node tail;
	
	public DLL() {
		this.head = null;
		this.tail = null;
	}
	
	public void push(Node newNode) {
		if(this.head == null) {
			this.head = newNode;
			this.tail= newNode;
			return;
		}
		Node lastNode = this.tail;
		lastNode.next = newNode;
		newNode.previous = lastNode;
		this.tail = newNode;
	}
	
	public void printValuesForward() {
		Node current = this.head;
		while(current != null) {
			System.out.println(current.value);
			current = current.next;
		}
	}
	public void printValuesBackwards() {
		Node runner = this.tail;
		while(runner != null) {
			System.out.println(runner.value);
			runner = runner.previous;
		}
	}
	public Node pop() {
		if(this.tail == null) {
			System.out.println("EMPTY");
		}
		Node runner = this.tail;
		Node temp = this.tail;
		runner = runner.previous;
		this.tail = runner;
		runner.next = null;
		return temp;
	}
	public boolean contains(Integer value) {
		if(this.head == null) {
			System.out.println("NO Nodes");
		Node runner = this.head;
		while(runner != null);
			if(runner.value == value) {
				System.out.println("Value found");
				return true;
			}
			runner = runner.next;
		}
		System.out.println("Not found");
		return false;
	}
	
}
