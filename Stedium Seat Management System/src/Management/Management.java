/*
 * Asraful Alam Ratul writes this class
 * Id : 21-44588-1
 * 
 * 
 */

package Management;
import Menus.Menu;
import Database.*;
import StediumStuffs.Account;
import StediumStuffs.Mail;
import StediumStuffs.Match;
import StediumStuffs.Ticket;
import Users.Admin;
import Users.Client;

public abstract class Management {
	public static void ManageMatch(Match match) { 		// match manager
		int choice;
		while(true) {
			
			Tools.clear();
			
			match.fullDetails();
			
			// manage match menu
			
			Menu.menus.matchControlMenu();
			
			choice = Tools.getInputI(null);
			
			switch (choice) {
			case 0: {
				return;
			}
			
			case 1: {		// change description
				Tools.clear();
				System.out.println(Menu.space + "\t\t==== Current Description ====\n" + Menu.space + match.getDesciption());
				match.setDesciption(Tools.getInput("Enter new description"));
				break;
			}

			case 2: {		// change match type
				Tools.clear();
				System.out.println(Menu.space + "Current match type : " + match.getMatchType());
				match.setMatchType(Tools.getInput("Enter new match type"));
				break;	
			}
			
			case 3: {		// change match date
				Tools.clear();
				System.out.println(Menu.space + "Current match date : " + match.getMatchDay());
				match.setMatchDay(Tools.getInput("Enter new match date"));
				break;	
			}
			
			case 4: {		// change vip seat manage
				while(true) {
					do {
						Tools.clear();
						
						// vip seat management menu
						Menu.menus.vipSeatManage(match.getVipSeats());
						
						choice = Tools.getInputI(null);
					}while(!(choice >= 0 && choice < 5));
					
					if(choice == 4) {
						match.setVipSeats(0);
						Menu.menus.popup("Changed to 0");
						continue;
					}
					else if(choice == 0) {
						break;
					}
					Tools.clear();
					System.out.print(Menu.space + "Enter seat(s) (Current : " + match.getVipSeats() + ") : ");
					int seat = Tools.getInputI(null);
					
					if(seat < 0) {
						Menu.menus.popup("Failed to change");
						continue;
					}
					else if(choice == 1) {
						match.addVipSeats(seat);
					}
					else if(choice == 2) {
						match.setVipSeats(seat);
					}
					else if(choice == 3) {
						if(match.getVipSeats() >= seat) {
							match.removeVipSeats(seat);
						}else {
							Tools.clearPrintHold("Cannot remove.");
						}
					}
	
					Menu.menus.popup("Successfully changed");
					continue;
				}
				break;
			}

			case 5: {				// change  normal seat details
				while(true) {
					do {
						Tools.clear();
						
						Menu.menus.normalSeatManage(match.getNormalSeats());
						
						choice = Tools.getInputI(null);
					}while(!(choice >= 0 && choice < 5));
					
					if(choice == 4) {
						match.setNormalSeats(0);
						Menu.menus.popup("Changed to 0");
						continue;
					}
					else if(choice == 0) {
						break;
					}
					
					System.err.print(Menu.space + "Enter seat(s) (Current : " + match.getNormalSeats() + ") : ");
					int seat = Tools.getInputI(null);
					
					
					if(seat < 0) {
						Menu.menus.popup("Failed to change");
						continue;
					}
					else if(choice == 1) {
						match.addNormalSeats(seat);
					}
					else if(choice == 2) {
						match.setNormalSeats(seat);
					}
					else if(choice == 3) {
						if(match.getNormalSeats() >= seat) {
							match.removeNormalSeats(seat);
						}else {
							Tools.clearPrintHold("Cannot remove.");
						}
					}
					
					Menu.menus.popup("Successfully changed");
					continue;
				}
				break;
			}
			
			case 6: {		// change validity
			
				Tools.clear();
				System.out.println(Menu.space + "Current validity : " + match.getValid());
				System.out.print("\n" + Menu.space + "any invalid input set auto invalid\n"
						+ Menu.space + "1. valid\n"
						+ Menu.space + "2. invalid\n\n"
						+ Menu.space + "  >> ");
				
				choice = Tools.getInputI(null);
				if(choice == 1) {
					match.setValid(true);
					Tools.clearPrintHold("Validity changed to : Valid");
				}
				else {
					match.setValid(false);
					Tools.clearPrintHold("Validity changed to : Invalid");
				}
				break;
			}
			
			case 7:{			//  delete match
				// delete match permanently
				Tools.clear();
				System.out.print(Menu.space + "Are your sure to remove this Match ?\n"
						+ Menu.space + "1. Yes\n"
						+  Menu.space + "2. No\n"
						+  Menu.space + "3. Cancel\n"
						+  Menu.space + "  >> ");
				
				choice = Tools.getInputI(null);
				if(choice == 1) {
					Client clients[] = match.getClients();
					
					for(int i = 0; i < clients.length; i++) {				// if match removed by admin then all client get their money back with a confirmation email..
						if(clients[i]!= null ) {
							if(clients[i].searchTicket(match.getId()).getType().equals("VIP")) {		// for vip seats
								clients[i].getAccount().addBalance(match.getVipCost() * clients[i].searchTicket(match.getId()).getQuantities());
							}
							else {		// for normal seats 
								clients[i].getAccount().addBalance(match.getNormalCost() * clients[i].searchTicket(match.getId()).getQuantities());
							}
							clients[i].addMail(new Mail("System Generated Mail", "Match id [" + match.getId() + "] is removed by admin.\n" + Menu.space + "Money refunded.", true)); // sending confirmation email
							clients[i].removeTicket(match.getId());
						}
					}
					
					Database.removeMatch(match);
					Tools.clearPrintHold("Match Removed");
					return;
				}
				else {
					Tools.clearPrintHold("Operation cancelled");
				}
				break;
			}
			
			default:
				System.out.println(Menu.space + "Invalid choise... press enter to continue");
				Database.scanner.nextLine();
			}
			
		}
	}
	
	//
	
	
	public static void manageTicket(Ticket ticket) {		// ticket manager 
		int choice;
		
		while(true) {
			
			Menu.menus.ticketManageMenu();
			
			choice = Tools.getInputI(null);
			
			switch(choice) {
				case 0 :{		// back
					return;
				}
				case 1 :{			// change id
					System.out.println(Menu.space + "Current id is : " + ticket.getId());
					ticket.setId(Tools.getInput("Enter new id"));
					break;
				}
				case 2 :{		// change seat quantities
					System.out.println(Menu.space + "Current seat available : " + ticket.getQuantities());
					ticket.setQuantities(Tools.getInputI("Enter new Quantities"));
					break;
				}
				case 3 :{		// change price
					System.out.println(Menu.space + "Current price is : " + ticket.getPrice());
					ticket.setPrice(Tools.getInputD("Enter new price"));
					break;
				}
				default : {		// invalid choice handle 
					System.out.println(Menu.space + "Invalid. Try again please");
				}
			}
		}
	}
	
	//
	
	public static void manageClient(Client client) {		// manage client
		int choice;
		
		while(true) {
			
			Tools.clear();
			
			System.out.println(Menu.space + "==== Manage Client ====\n\n");
			
			client.shortProfile();
			
			// client management menu
			
			Menu.menus.clientManagementMenu();
			
			Menu.menus.selectMenu();
			
			choice = Tools.getInputI(null);
			
			switch (choice) {
				case 0:{
					return;
				}
				
				case 1:{		// change name\
					Tools.clear();
					System.out.println(Menu.space + "Current Name : " + client.getName());
					client.setName(Tools.getInput("Enter new name"));
					break;
				}
				
				case 2:{		// change age
					Tools.clear();
					System.out.println(Menu.space + "Current Age : " + client.getAge());
					client.setAge(Tools.getInputI("Enter new age"));
					break;
				}
				
				case 3:{		// change gender
					Tools.clear();
					System.out.println(Menu.space + "Current Gender : " + client.getGender());
					client.setGender(Tools.getInput("Enter new gender"));
					break;
				}
				
				case 4:{		// change number
					Tools.clear();
					System.out.println(Menu.space + "Current Number : " + client.getNumber());
					client.setNumber(Tools.getInput("Enter new number"));
					break;
				}
				
				case 5:{		// change address
					Tools.clear();
					System.out.println(Menu.space + "Current Address : " + client.getAddress());
					client.setAddress(Tools.getInput("Enter new Address"));
					break;
				}
				
				case 6:{		// change email
					Tools.clear();
					System.out.println(Menu.space + "Current Email : " + client.getEmail());
					client.setEmail(Tools.getInput("Enter new email"));
					break;
				}
				
				case 7:{		// manage client account information
					
					Menu : while(true) {
						
						Tools.clear();
						
						
						// manage account menu
						Menu.menus.accountManageMenu(client.getAccount().getBalance());
						
						choice = Tools.getInputI(null);
						switch(choice) {
							case 0 :{		//  back
								break Menu;
							}
							
							case 1 :{		// change current balance
								Tools.clear();
								System.out.println(Menu.space + "Current Balance : " + client.getAccount().getBalance());
								client.getAccount().setBalance(Tools.getInputD("Enter new balance"));
								
								break;
							}
							
							case 2 :{		//  deposit money
								Tools.clear();
								client.getAccount().deposid(Tools.getInputD("Enter the amount of money you want to deposit"));
								
								break;
							}
						}
					}
					
					break;
				}
				
				case 8:{		// manage client tickets
					
					while(true) {
						
						Tools.clear();
						
						
						if(client.countTickets() == 0) {
							Menu.menus.emptyMenu();
							break;
						}
						
						client.showAllTickets();
						
						Menu.menus.selectMenu();
						
						String id = Tools.getInput("Enter ticket id (back on 0)");
						
						if(client.searchTicket(id) != null) {
							Management.manageTicket(client.searchTicket(id));
						}
						else {
							Tools.clearPrintHold("Invalid id");
						}
						
					}
					
					break;
				}
				
				case 9: {			// remove client
					Tools.clear();
					System.out.print(Menu.space + "Are your sure to remove this person ?\n"
							+ Menu.space + "1. Yes\n"
							+  Menu.space + "2. No\n"
							+  Menu.space + "3. Cancel\n"
							+  Menu.space + "  >> ");
					
					choice = Tools.getInputI(null);
					if(choice == 1) {
						Database.removeClient(client);
						Tools.clearPrintHold("Client rmeoved");
						return;
					}
					else {
						Tools.clearPrintHold("Operation cancelled");
					}
					
					
					
				break;	
				}
				default :{
					Tools.clearPrintHold("Invalid choice");
				}

			}
		}
	}
	
	//
	
	
	public static void manageAccount(Account account) {		// manage account
		while(true) {
			
			Tools.clear();
			
			Menu.menus.accountManageMenu(account.getBalance());
			int choice = Tools.getInputI(null);
			
			switch(choice) {			// back
				case 0:{
					return;
				}
				
				case 1:{		// change current balance
					System.out.println(Menu.space + "Current balance is : " + account.getBalance());
					account.setBalance(Tools.getInputD("Enter new balance"));
					break;
				}
				
				case 2:{		// deposit amount
					account.deposid(Tools.getInputD("Entere amaunt"));
					break;
				}
				
				default:{		// check invalid
					System.out.println(Menu.space + "Invalid choice");
				}
			}
		}
		
		
	}
	
	public static void changeAdminUP(Admin admin){		// change admin username and password
		while(true) {
			Tools.clear();
			System.out.print(Menu.space + "==== Username and Password Setting ====\n\n"
					+ Menu.space + "1. Change username\n"
					+ Menu.space + "2. Change password\n"
					+ Menu.space + "0. Back\n\n"
					+ Menu.space + "  >> ");
			
			int choice = Tools.getInputI(null);
			
			switch(choice) {		// back
				case 0 :{
					return;
				}
				
				case 1 :{		// change username
					Tools.clear();
					System.out.println(Menu.space + "Current username : " + admin.getUsername());
					String username = Tools.getInput("Enter new username");
					if(Database.isUsernameExist(username)) {
						Tools.clearPrintHold("Username already taken");
						break;
					}
					else {
						Tools.clearPrintHold("Username changed to : " + username);
						admin.setUsername(username);
					}
					break;
				}
				
				case 2 :{		// change password
					Tools.clear();
					admin.setPassword(Tools.getInput("Enter new password"));
					Tools.clearPrintHold("Password Changed");
					break;
				}
				
				default : {		// check invalid
					Tools.clearPrintHold("Invalid option");
				}
			}
		}
	}
	
	
	public static void changeClientUP(Client client){		// change client username and password
		while(true) {
			Tools.clear();
			System.out.print(Menu.space + "==== Username and Password Setting ====\n\n"
					+ Menu.space + "1. Change username\n"
					+ Menu.space + "2. Change password\n"
					+ Menu.space + "0. Back\n\n"
					+ Menu.space + "  >> ");
			
			int choice = Tools.getInputI(null);
			
			switch(choice) {		// back
				case 0 :{
					return;
				}
				
				case 1 :{		// change username
					Tools.clear();
					System.out.println(Menu.space + "Current username : " + client.getUsername());
					String username = Tools.getInput("Enter new username");
					if(Database.isUsernameExist(username)) {
						Tools.clearPrintHold("Username already taken");
						break;
					}
					else {
						Tools.clearPrintHold("Username changed to : " + username);
						client.setUsername(username);
					}
					break;
				}
				
				case 2 :{		// change password
					Tools.clear();
					client.setPassword(Tools.getInput("Enter new password"));
					Tools.clearPrintHold("Password Changed");
					break;
				}
				
				default : {		// check invalid
					Tools.clearPrintHold("Invalid option");
				}
			}
		}
	}
	
	//
	
	
	public static boolean canBuy(Client client, double money) {		// check a user can buy a ticket or not
		if(client.getAccount().getBalance() >= money) {
			client.getAccount().removeBalance(money);
			return true;
		}
		return false;
	}
}
