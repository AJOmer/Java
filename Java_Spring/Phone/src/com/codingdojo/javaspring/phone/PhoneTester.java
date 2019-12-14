package com.codingdojo.javaspring.phone;

public class PhoneTester {
	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 97, "AT&T", "BRRR BRRR BRR");
		IPhone iphoneten = new IPhone("X", 75, "Verizon", "zzzZZZZZ BRZZzz");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iphoneten.displayInfo();
		System.out.println(iphoneten.ring());
		System.out.println(iphoneten.unlock());
	}
}
