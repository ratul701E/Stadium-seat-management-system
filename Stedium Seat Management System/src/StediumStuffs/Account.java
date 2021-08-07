package StediumStuffs;

import Menus.Menu;

public class Account {
	private double balance;
	
	public Account() {
		
	}
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	
	// sets
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	// gets
	
	public double getBalance() {
		return balance;
	}
	
	// remove
	
	public void removeBalance(double amount) {
		if(amount > 0) {
			this.balance -= amount;
		}
	}
	
	// deposid
	
	public void deposid(double balance) {
		if(balance < 500) {
			System.out.println(Menu.space + "You cannot add less than 500. Please try with more money");
			
		}
		
		else this.balance += balance;
	}
}
