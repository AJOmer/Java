package com.codingdojo.springjava.bankaccount;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount bank1 = new BankAccount();
		BankAccount bank2 = new BankAccount();
		
		bank1.depositMoney("checkings", 199.20);
		bank2.depositMoney("Savings", 552.44);
		bank2.depositMoney("Savings", 2234.99);
		bank1.depositMoney("checkings", 20.27);
		bank1.withdrawMoney("Savings", 50.00);
		bank1.depositMoney("Savings", 3000.20);
		bank2.withdrawMoney("Savings", 2000.99);
		
		bank1.myTotal();
		bank2.myTotal();
		}
}
