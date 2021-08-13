/*
 * Fardin Ibna Rahman writes this class
 * Id : 21-44705-1
 * 
 */

package StediumStuffs;

import java.io.Serializable;

import Management.Tools;
import Menus.Menu;

public class Account implements Serializable {
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
			Tools.clearPrintHold("You cannot add less than 500. Would you mind trying with more money");
			
		}
		
		else this.balance += balance;
	}
	
	public void addBalance(double balance) {
		this.balance += balance;
	}
}
