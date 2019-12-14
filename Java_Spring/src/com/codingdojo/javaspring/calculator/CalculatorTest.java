package com.codingdojo.javaspring.calculator;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator calc1 = new Calculator(10.5, "+", 5.2);
		Calculator calc2 = new Calculator(25.5,"-", 10.5);
		
		calc1.performOperation();
		calc2.performOperation();
		calc1.getResults();
		calc2.getResults();
	}
}
