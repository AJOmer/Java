package com.codingdojo.springjava.bankaccount;
import java.util.Random;

public class BankAccount {
	///attributes
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	private static int numberOfAccounts = 0;
	private static double moneyInAccount = 0.0;
	
	///constructors
	
	public BankAccount() {
		String accountNumber = newAccount();
		double checkingBalance = 0.0;
		double savingsBalance = 0.0;
		numberOfAccounts +=1;
		System.out.println("New account created: " + accountNumber);
		System.out.println("Total accounts are: " + numberOfAccounts);
	}
	
	///getters
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	///setters
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	////methods
	private String newAccount() {
		String numberTable = "0123456789";
		String randNum = "";
		Random rand = new Random();
		
		for(int i = 0; i< 10; i++) {
			char num = numberTable.charAt(rand.nextInt(10));
			randNum += num;
		}
		accountNumber = randNum;
		return randNum;
	}
	public void depositMoney(String accountType, double depositAmount) {
		if(accountType == "checkings" || accountType == "Checkings") {
			setCheckingBalance(getCheckingBalance()+ depositAmount);
			moneyInAccount += depositAmount;
		}
		if(accountType == "savings" || accountType == "Savings") {
			setSavingsBalance(getSavingsBalance()+ depositAmount);
			moneyInAccount += depositAmount;
		}
		else {
			System.out.println("Choose an account");
		}
	}
	public void withdrawMoney(String accountType, double withdrawAmount) {
		if(accountType == "checkings" || accountType == "Checkings") {
			if(getCheckingBalance() < withdrawAmount) {
				System.out.println("insufficient funds");
			}
			else {
				setCheckingBalance(getCheckingBalance()-withdrawAmount);
				moneyInAccount -=withdrawAmount;
			}
		}
		if(accountType == "savings" || accountType == "Savings") {
			if(getSavingsBalance() < withdrawAmount) {
				System.out.println("Insufficient funds broke boi");
			}
			else {
				setSavingsBalance(getSavingsBalance()-withdrawAmount);
				moneyInAccount -= withdrawAmount;
			}
		}
	}
	public double myTotal() {
		double moneyInAccount = checkingBalance + savingsBalance;
		System.out.println(moneyInAccount);
		return moneyInAccount;
	}
	
}
