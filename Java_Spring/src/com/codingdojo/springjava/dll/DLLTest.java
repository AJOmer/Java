package com.codingdojo.springjava.dll;

public class DLLTest {
	public static void main(String[] args) {
		DLL list1 = new DLL();
		Node n1 = new Node(11);
		Node n2 = new Node(21);
		Node n3 = new Node(31);
		Node n4 = new Node(41);
		Node n5 = new Node(51);
		
		list1.push(n1);
		list1.push(n2);
		list1.push(n3);
		list1.push(n4);
		list1.push(n5);
		
		list1.printValuesForward();
		
		list1.printValuesBackwards();
		
		list1.contains(31);
		list1.contains(54);
		
	}
}
