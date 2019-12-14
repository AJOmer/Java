package com.codingdojo.javaspring.calculator;

public class Calculator {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double myTotal;
	
	public Calculator() {
		
	}
	
	public Calculator(double operandOne,String operation, double operandTwo){
		this.operandOne = operandOne;
		this.operation = operation;
		this.operandTwo = operandTwo;
		
	}
	///setters
	public void setOperandOne(double o1) {
		this.operandOne = o1;
	}
	public void setOperandTwo(double o2) {
		this.operandTwo = o2;
	}
	public void setOperation(String op) {
		this.operation = op;
	}
	public void setMyTotal(double total) {
		this.myTotal = total;
	}
	////getters
	public double getOperandOne() {
		return operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public String getOperation() {
		return operation;
	}
	public double getMyTotal() {
		return myTotal;
	}
	
	///methods
	
	public void performOperation() {
		if(getOperation().equals("+")) {
			double total = getOperandOne() + getOperandTwo();
			setMyTotal(total); 
		}
		else if(getOperation().equals("-")) {
			double total = getOperandOne()- getOperandTwo();
			setMyTotal(total);
		}
	}
	public void getResults() {
		System.out.println(getMyTotal());
	}
}
