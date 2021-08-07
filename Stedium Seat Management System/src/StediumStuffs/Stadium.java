package StediumStuffs;


import Database.Database;
import Management.Management;
import Management.Tools;
import Menus.Menu;
import Users.*;

public class Stadium {
	
	
	public void startServer() {
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
					// Group1Stedium.aboutUs();
					break;
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
					username = Tools.getInput("Username");
					password = Tools.getInput("Password");
					
					if(Database.isExistClinet(username, password) == 2) {
						Tools.clearPrintHold("Logged in");
						
						//
						this.accessUser(username);
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
					String username = Tools.getInput("Username");
					String password = Tools.getInput("Password");
					if(Database.isAdmin(username,password)) {
						Tools.clearPrintHold("logged in");
						
						this.accessAdmin(username);
						
					}
					
					else {
						Tools.clearPrintHold("This account dosen't exist or not a admin account");
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
		System.out.println(Menu.space + "==== Signup Page ====\n");
		
		while(true) {
			
			Tools.clear();
			
			System.out.print(Menu.space + "1. As client\n"
					+ Menu.space + "2. As admin\n"
					+ Menu.space + ">> ");
			int choice = Tools.getInputI(null);
			if(choice == 2) {
				isAdmin = true;
				break;
			}
			else if(choice != 1) {
				System.out.println(Menu.space + "Invalid choice");
			}
			else break;
		}
		
		name = Tools.getInput("Enter your name*");
		age = Tools.getInputI("Enter your age*");
		gender = Tools.getInput("Enter your gender*");
		number = Tools.getInput("Enter your number*");
		address = Tools.getInput("Enter your address*");
		email = Tools.getInput("Enter your email*");
		
		while(true) {
			
			Tools.clear();
			
			username = Tools.getInput(("Enter your username*"));
			if(!Database.isUsernameExist(username)) {
				break;
			}
			System.out.println(Menu.space + "username is taken.. try diffrent name please");

		}
		
		password = Tools.getInput("Enter your password");
		
		if(isAdmin) {
			Database.addAdmin(new Admin(name,age,gender,number,address,email,username, password));
		}
		else Database.addClient(new Client(name,age,gender,number,address,email,username, password, new Account(5000)));
		System.out.println(Menu.space + "Account created successfully");
		
		// enter to continue
		
		
	}
	
	
	private Ticket bookTicket(Client client, Match match) {

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
				int seatCount = Tools.getInputI("How many seat you want");
				
				if(Management.canBuy(client, match.getVipCost()*seatCount) && match.getVipSeats()>= seatCount) {
					match.removeVipSeats(seatCount);
					Tools.clearPrintHold("Booked");
					return new Ticket(match.getId(), seatCount, seatCount*match.getVipCost(),1);
					
				}
				else {
					Menu.menus.ticketBuyErr();
				}
				break;
			}
			
			case 2:{
				// booking normal seats
				int seatCount = Tools.getInputI("How many seat you want");
				
				if(Management.canBuy(client, match.getNormalCost()*seatCount) && match.getNormalSeats()>= seatCount ) {
					match.removeNormalSeats(seatCount);
					Tools.clearPrintHold("Booked");
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
	
	private void accessUser(String username) {
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
						
						client.showAllTickets();
						
						System.out.print(Menu.space + "\n1. Cancel ticket\n"
								+ Menu.space +  "0. Back\n"
								+ Menu.space + "   >> ");
						choice = Tools.getInputI(null);
						
						switch(choice) {
							case 1:{
								System.out.println(Menu.space + "Enter ID : ");
								Ticket ticket = client.searchTicket(Tools.getInput(null));
								if(ticket != null) {
									if(client.removeTicket(ticket)) {
										System.out.println(Menu.space + "Cancelled");
										client.addToCancelledTicket(ticket);
									} else {
										System.out.println(Menu.space + "Can't cancel");
									}
								}
								else {
									System.out.println(Menu.space + "Invalid ID");
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
									client.addTicket(ticket);
									client.addToPurchaseHistory(ticket);
									
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
					
					break;
				}
				
				case 5 :{
					Tools.clear();
					
					//notifications
					
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
					// manage clients
					while(true) {
						
						Tools.clear();
						
						Database.showAllClients();
						
						String TempUsername = Tools.getInput("Enter client username (type exit to exit)");
						if(TempUsername.equalsIgnoreCase("exit")) {
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
				
				case 3 : {
					// mailings
					
					innerMenu : while(true) {
						
						Tools.clear();
						
						
						System.out.print(Menu.space + "==== Mailing ====\n\n"
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
									System.out.println(Menu.space + "Invalid receiver email.");
									Tools.etoc();
								}
								else {
									receiver.addMail(new Mail(admin.getEmail(), message,true));
									System.out.println(Menu.space + "Email sent successfully");
									Tools.etoc();
								}
								
								break;
							}
						}
						
					}
					
					break;
				}
				
				case 4 : {
					// notifications
					
					
					break;
				}
			}
		}
	}
}
