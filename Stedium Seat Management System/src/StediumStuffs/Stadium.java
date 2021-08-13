/*
 * Whole team writes this class
 */

package StediumStuffs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Database.Database;
import Management.Management;
import Management.Tools;
import Menus.Menu;
import Users.*;

public class Stadium {
	
	
	public void startServer() { 	// Starting the server
		Database.restoreData();
		int choice;
		while(true) {
		
			Tools.clear();
			
			
			Menu.menus.portalMenu();
			
			choice = Tools.getInputI(null);
			
			switch(choice) {
			
				case 1 : {
					this.login();
					break;
				}
				
				case 2 : {
					this.signup();
					break;
				}
				
				case 3 : {
					contributions();
					break;
				}
				
				case 4 : {
					this.aboutUs();
					break;
				}
				
				case 0 :{
					Database.saveData();
					return;
				}
				
				default :{
					Tools.clearPrintHold("Invalid message");
				}
			}
		}
	}
	
	
	
	
	private void login() {
		
		
		while(true) {
			
			Tools.clear();
			
			Menu.menus.loginMenu();
			
			int choice = Tools.getInputI(null);
			
			Tools.clear();
			
			switch (choice) {
				case 1: {
					String username, password;
					System.out.println(Menu.space + "==== Client login ====\n\n");
					username = Tools.getInput("Username");
					password = Tools.getInput("Password");
					
					if(Database.isExistClinet(username, password) == 2) {
						Tools.clearPrintHold("Logged in");
						
						//
						this.accessClient(username);
						//
						
						 break;
						
					}else if(Database.isExistClinet(username, password) == 1) {
						Tools.clearPrintHold("Invalid password");
					}else {
						Tools.clearPrintHold("No user found");
					}
					
					break;
				}
				
				case 2: {
					System.out.println(Menu.space + "==== Admin login ====\n\n");
					String username = Tools.getInput("Username");
					String password = Tools.getInput("Password");
					if(Database.isAdmin(username,password)) {
						Tools.clearPrintHold("logged in");
						
						this.accessAdmin(username);
						
					}
					
					else {
						Tools.clearPrintHold("This account dosen't exist or not an admin account");
					}
					
					break;
					
				}
				
				case 0:{
					
					return;
				}
				
				default : {
					Tools.clearPrintHold("Invaild.. try again");
				}
			}
		}
	}
	
	//
	
	
	private void signup() {
		
		Tools.clear();
		
		String name, gender, number, address, email, username, password;
		boolean isAdmin = false;
		
		
		int age;
		
		
		while(true) {
			
			Tools.clear();
			System.out.println(Menu.space + "==== Create New Account ====\n\n");
			System.out.print(Menu.space + "1. As client\n"
					+ Menu.space + "2. As admin\n"
					+ Menu.space + "0. Back\n"
					+ Menu.space + ">> ");
			int choice = Tools.getInputI(null);
			if(choice == 0) return;
			if(choice == 2) {
				isAdmin = true;
				break;
			}
			else if(choice != 1) {
				System.out.println(Menu.space + "Invalid choice");
			}
			else break;
		}
		
		Tools.clear();
		
		name = Tools.getInput("Enter your name*");
		age = Tools.getInputI("Enter your age*");
		gender = Tools.getInput("Enter your gender*");
		number = Tools.getInput("Enter your number*");
		address = Tools.getInput("Enter your address*");
		email = Tools.getInput("Enter your email*");
		
		while(true) {
			
			Tools.clear();
			
			System.out.println(Menu.space + "==== Please Remember Username and Password ====\n\n");
			
			username = Tools.getInput(("Enter your username*"));
			if(!Database.isUsernameExist(username)) {
				break;
			}
			System.out.println(Menu.space + "username is taken.. try diffrent name please");

		}
		
		password = Tools.getInput("Enter your password*");
		
		if(isAdmin) {
			Database.addAdmin(new Admin(name,age,gender,number,address,email,username, password));
		}
		else Database.addClient(new Client(name,age,gender,number,address,email,username, password, new Account(1000)));
		Tools.clearPrintHold("Account created successfully");
		
		// enter to continue
		
		
	}
	
	
	private Ticket bookTicket(Client client, Match match) {
		
		if(!match.getValid()) {
			Tools.clearPrintHold("An admin turns off this match reservation.");
			return null;
		}

		Tools.clear();
		System.out.println(Menu.space + "==== Welcome to Ticket Counter ====\n\n");
		match.fullDetails();
		
		System.out.print(Menu.space + "1. Vip\n"
				+ Menu.space + "2. Normal\n"
				+ Menu.space + "0. Cancel\n"
				+ "\n"+ Menu.space + "   >> ");
		
		int choice = Tools.getInputI(null);
		
		switch(choice) {
			case 0:{
				return null;
			}
			
			case 1:{
				// booking vip seats
				int seatCount = Tools.getInputI("How many seats do you want");
				
				if(match.getVipSeats()>= seatCount && Management.canBuy(client, match.getVipCost()*seatCount)) {
					match.removeVipSeats(seatCount);
					Tools.clearPrintHold("Booked");
					match.addClient(client);
					return new Ticket(match.getId(), seatCount, seatCount*match.getVipCost(),1);
					
				}
				else {
					Menu.menus.ticketBuyErr();
				}
				break;
			}
			
			case 2:{
				// booking normal seats
				int seatCount = Tools.getInputI("How many seats do you want");
				
				if(match.getNormalSeats()>= seatCount && Management.canBuy(client, match.getNormalCost()*seatCount)) {
					match.removeNormalSeats(seatCount);
					Tools.clearPrintHold("Booked");
					match.addClient(client);
					return new Ticket(match.getId(), seatCount, seatCount*match.getNormalCost(),2);
				}
				else {
					Menu.menus.ticketBuyErr();
				}
				break;
			}
			
			default:{
				Tools.clearPrintHold("Error");
			}
			
		}
		return null;
		
	}
	
	
	//
	
	private void accessClient(String username) {
		Client client = Database.getClinet(username);
		
		MenuLabel : while(true) {
			
			Tools.clear();
			
			Menu.menus.clientInterface(client.newMails());
			int choice = Tools.getInputI(null);
			
			switch(choice) {
				case 0 :{
					//exit
					break MenuLabel;
				}
				
				case 1 :{
					//my tickets
					
					innerMenu: while(true) {
						
						Tools.clear();
						
						if(!client.showAllTickets()) break innerMenu;
						
						System.out.print("\n" + Menu.space + "1. Show Match details\n"
								+ Menu.space + "2. Cancel ticket\n"
								+ Menu.space +  "0. Back\n\n"
								+ Menu.space + "   >> ");
						choice = Tools.getInputI(null);
						
						switch(choice) {
						
							case 1 : {
								String id = Tools.getInput("Enter ID : ");
								if(Database.searchMatch(id) != null) {
									Tools.clear();
									Database.searchMatch(id).fullDetails();
									Tools.etoc();
								}else {
									Tools.clearPrintHold("Invalid ticket id");
								}
								break;
							}
							
							case 2:{
								String id = Tools.getInput("Enter ID : ");
								
								if(client.removeTicket(id)) {
									Tools.clearPrintHold("Cancelled");
								} else {
									Tools.clearPrintHold("Cannot cancel");
								}
								
								
							}
							
							case 0:{
								break innerMenu;
							}
							
							default: {
								System.out.println(Menu.space + "Invalid choice");
							}
						}
					}
					
					break;
				}
				
				case 2 :{
					//buy tickets
					
					inner: while(true) {
						
						Tools.clear();
						if(Database.countMatch() == 0) {
							Menu.menus.emptyMenu();
							break inner;
						}
						Database.showAllMatches();
						
						Menu.menus.buyNewTicketMenu();
						
						choice = Tools.getInputI(null);
						
						switch(choice) {
							case 0: {
								break inner;
							}
							
							case 1: {
								String id = Tools.getInput("      Enter match id");
								
								if(Database.searchMatch(id) == null) {
									System.out.println(Menu.space + "      Invalid id");
								}
								else {
									Ticket ticket = this.bookTicket(client,Database.searchMatch(id));
									if(ticket != null) {
										client.addTicket(ticket);
										client.addToPurchaseHistory(ticket);
									}
								}
								break;
							}
							
							default:{
								System.out.println(Menu.space + "      Invaid input\n");
							}
						}
					}
					
					break;
				}
				
				case 3 :{
					Tools.clear();
					//cancelled tickets
					
					Ticket cancelledTickets[] = client.getCancelledTickets();
					
					if(client.countCancelldTickets() == 0) {
						Menu.menus.emptyMenu();
						break;
					}
					
					for(int i = 0; i < cancelledTickets.length; i++) {
						if(cancelledTickets[i]!= null ) {
							cancelledTickets[i].showTicket();
						}
					}
					
					Tools.etoc();
					
					break;
				}
				
				case 4 :{
					Tools.clear();
					//purchase tickets
					
					Ticket purchasedTickets[] = client.getPurchasedTickets();
					
					if(client.countPurchedTickets() == 0) {
						Menu.menus.emptyMenu();
						break;
					}
					
					for(int i = 0; i < purchasedTickets.length; i++) {
						if(purchasedTickets[i]!= null ) {
							purchasedTickets[i].showTicket();
						}
					}
					
					Tools.etoc();
					
					break;
				}
				
				case 5 :{
					Tools.clear();
					
					//Change user-name and password
					Management.changeClientUP(client);
					break;
				}
				
				case 6 :{
					Tools.clear();
					
					//Account
					System.out.println(Menu.space + "Account balance : " + client.getAccount().getBalance());
					Tools.etoc();
					
					break;
				}
				
				case 7 :{
					// mailings
					
					menuLoop: while(true) {
						
						Tools.clear();
						
						
						Menu.menus.mailMenu(client.newMails());
						
						choice = Tools.getInputI(null);
						
						switch(choice) {
							case 0 :{
								break menuLoop;
							}
							
							case 1 : {
								// inbox
								
								Tools.clear();
								
								client.setNewMails(false);
								System.out.println(Menu.space + "==== Inbox ====\n\n");
								
								if(client.countAllMails() == 0) {
									Menu.menus.emptyMenu();
									break;
								}
								
								Mail emails[] = client.getAllMails();
								
								for(int i = emails.length -1 ; i >= 0; i--) {
									if(emails[i]!= null ) {
										emails[i].showDetails();
									}
								}
								Tools.etoc();
								break;
							}
							
							case 2 :{
								//email to admin
								Tools.clear();
								
								String message;
								message = Tools.getInput("Enter your message");
								
								Admin.addMail(new Mail(client.getEmail(), message));
								
								Tools.clearPrintHold("Email sent successfully");
								
								break;
								

							}
							
							case 3 :{
								//email to client
								Tools.clear();
								
								String message;
								String recEmail;
								recEmail = Tools.getInput("Enter receiver email");
								message = Tools.getInput("Enter your message");
								
								Client receiver = Database.searchByEmail(recEmail);
								if(receiver == null) {
									Tools.clearPrintHold("Invalid receiver email.");
								}
								else {
									receiver.addMail(new Mail(client.getEmail(), message));
									Tools.clearPrintHold("Email sent successfully");
								}
								
								break;
							}
							
							default :{
								System.out.println(Menu.space + "Invalid choice");
							}
						}
					}
					
					break;
				}
				
				default : {
					
					
				}
			}
		}
		
	}
	
	//
	
	private void accessAdmin(String username) {
		Admin admin = Database.getAdmin(username);
		
		while(true) {
			
			Tools.clear();
			
			Menu.menus.adminInterface(admin.newMails());
			
			int choice = Tools.getInputI(null);
			
			switch(choice) {
				case 0 : {
					// logout
					return;

				}
				
				case 1 : {
					// add match
					
					Database.createMatch();
					
					break;
				}
				
				case 2 : {
					// manage matches
					
					admin.manageMatches();
					
					break;
				}
				
				case 3 : {
					// manage clients
					while(true) {
						
						Tools.clear();
						
						if(Database.countClients() == 0) {
							Menu.menus.emptyMenu();
							break;
						}
						
						Database.showAllClients();
						
						String TempUsername = Tools.getInput("Enter client username (back on 0)");
						if(TempUsername.equals("0")) {
							break;
						}
						Client  client= Database.getClinet(TempUsername);
						if(client != null) {
							Management.manageClient(client);
						}
						else {
							System.out.println(Menu.space + "Invalid username");
						}
					}
					
					break;
				}
				
				case 4 : {
					// mailings
					
					innerMenu : while(true) {
						
						Tools.clear();
						
						
						System.out.print(Menu.space + "==== Mail ====\n\n"
								+ Menu.space + "1. Inbox");
						
						if(admin.newMails()) System.out.println("   (new!)");
						else System.out.println();
						
						System.out.print(Menu.space + "2. Mail to client\n"
								+ Menu.space + "0. Back\n"
								+ Menu.space + "   >> ");
						choice = Tools.getInputI(null);
						
						switch(choice) {
							case 0 : {
								// back
								break innerMenu;
							}
							
							case 1 : {
								//inbox
								Tools.clear();
								
								Admin.setNewMails(false);
								System.out.println(Menu.space + "==== Inbox ====\n\n");
								
								if(admin.countAllMails() == 0) {
									Menu.menus.emptyMenu();
								}
								else {
									Mail mails[] = admin.getAllMails();
									for(int i = mails.length -1 ; i >= 0; i--) {
										if(mails[i]!= null) {
											mails[i].showDetails();
										}
									}
								}
								
								Tools.etoc();
								break;
							}
							
							case 2 : {
								//mail to client
								Tools.clear();
								
								String message;
								String recEmail;
								recEmail = Tools.getInput("Enter receiver email");
								message = Tools.getInput("Enter your message");
								
								Client receiver = Database.searchByEmail(recEmail);
								if(receiver == null) {

									Tools.clearPrintHold("Invalid receiver email.");
								}
								else {

									receiver.addMail(new Mail(admin.getEmail(), message,true));
									Tools.clearPrintHold("Email sent successfully");

								}
								
								break;
							}
						}
						
					}
					
					break;
				}
				
				case 5 : {
					// change username and password
					
					Management.changeAdminUP(admin);
					
					
					break;
				}
				
			}
		}
	}
	
	private void aboutUs() {
		String text="", temp;	
		try
		{
			FileReader reader = new FileReader("StediumStuffs/About/aboutUs.txt");	//src/StediumStuffs/About/aboutUs.txt		
			BufferedReader bfr = new BufferedReader(reader);					
			
			while((temp = bfr.readLine())!=null)		
			{
				text=text+temp+"\n"+"\r";			
			} 				
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		char inChars[] = text.toCharArray();
		
		Tools.clear();
		System.out.println(Menu.space + "\t\t\t==== About us ====\n\n");
		
		for(char i : inChars){
			
			System.out.print(i);
			try{
				Thread.sleep(10);
			}catch(Exception e){
				
			}
			
		}
		
		Tools.etoc();
	}
	
	private void contributions(){
		String text="", temp;	
		try
		{
			FileReader reader = new FileReader("StediumStuffs/About/contributions.txt");	//src/StediumStuffs/About/contributions.txt		
			BufferedReader bfr = new BufferedReader(reader);					
			
			while((temp = bfr.readLine())!=null)		
			{
				text=text+temp+"\n"+"\r";			
			} 				
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		char inChars[] = text.toCharArray();
		
		Tools.clear();
		System.out.println("\t\t\t\t==== Contributions ====\n\n");
		
		for(char i : inChars){
			
			System.out.print(i);
			try{
				Thread.sleep(10);
			}catch(Exception e){
				
			}
			
		}
		
		Tools.etoc();
	}
}
