package Menus;
import Management.Tools;

public class Menu{
	
	public static Menu menus = new Menu();
	
	
	public Menu() {}
	
	public void clientInterface(boolean newMails) {
		System.out.print("\t\t==== Client ====\n\n"
				+ "1. My tickets\n"
				+ "2. Buy tickets\n"
				+ "3. Cancelled tickets\n"
				+ "4. Purchase history\n"
				+ "5. Notifications\n"
				+ "6. Account information\n"
				+ "7. Compose mail and inbox");
		
		if(newMails) {
			System.out.println("  (new!)");
		}else {
			System.out.println();
		}
				
				System.out.print("0. Logout\n"
				+ ">> ");
	}
	
	public void adminInterface(boolean newMails) {
		System.out.print("\t\t==== Admin Panel ====\n\n"
				+ "1. Add match\n"
				+ "2. Manage Clients\n"
				+ "3. Mailings");
		if(newMails) {
			System.out.println("  (new!)");
		}else {
			System.out.println();
		}
				System.out.print("4. Notifications\n"
				+ "0. Logout\n"
				+ ">> ");
	}
	
	
	
	public void matchControlMenu() {
		System.out.print("\t\t==== Manage Match  ====\n\n" // ( Match ID : " + match.getId() + " )
				+ "1. Change description\n"
				+ "2. Change match type\n"
				+ "3. Change Match Day\n"
				+ "4. Change/modify vip seat number\n"
				+ "5. Change/modify normal seat numbers\n"
				+ "6. Change validity\n"
				+ "0. Exit \n>>"); 
	}
	
	public void vipSeatManage(int seats) {
		System.out.print("\t\t==== Vip Seat Management (seat : " + seats + " ) ====\n\n"
				+ "1. Add seat(s)\n"
				+ "2. Change total seat\n"
				+ "3. Remove seat\n"
				+ "4. Make empty\n"
				+ "0. Exit\n"
				+ " >> ");
	}
	
	
	public void normalSeatManage(int seats) {
		System.out.print("\t\t==== Normal Seat Management (seat : " + seats + " ) ====\n\n"
				+ "1. Add seat(s)\n"
				+ "2. Change total seat\n"
				+ "3. Remove seat\n"
				+ "4. Make empty\n"
				+ "0. Exit\n"
				+ " >> ");
	}
	
	
	public  void selectMenu() {
		System.out.println("\nSelect one to modify");
		System.out.print("_exit key 0_ >> ");
	}
	
	
	public void clientManagementMenu() {
		System.out.println(
				 "1. Change name\n"
				+ "2. Change Age\n"
				+ "3. Change Gender\n"
				+ "4. Change number\n"
				+ "5. Change Address\n"
				+ "6. Change Email\n"
				+ "7. Account details\n"
				+ "8. Manage Tickets\n"
				+ "0. Exit\n");
	}
	
	
	public void accountManageMenu(double balance) {
		System.out.print("\t\t==== Manage Account (Available alance :" + balance + ")====\n\n"
				+ "1. Change Balance (sensitive)\n"
				+ "2. Deposit Money\n"
				+ "0. Exit\n"
				+ ">> ");
	}
	
	
	public void ticketManageMenu() {
		System.out.print("\t\t==== Ticket Manager ====\n\n"
				+ "1. Change ID (be careful)\n"
				+ "2. Change seat quantites\n"
				+ "3. Change Price\n"
				+ "0. Exit\n"
				+ ">> ");
	}
	
	
	public void loginMenu() {
		System.out.print("\t\t\t\t==== Log in Menu ====\n\n"
				+ "1. Client login\n"
				+ "2. Admin login\n"
				+ "0. Back\n"
				+ ">> ");
	}
	
	
	public void portalMenu() {
		Tools.clear();
		System.out.print("\t\t\t\t==== Stedium Portal ====\n\n"
				+ "1. Log in menu\n"
				+ "2. Sign in menu\n"
				+ "3. About us\n"
				+ ">> ");
	}
	
	public void mailMenu() {
		System.out.print("\t\t==== Mail ====\n\n"
				+ "1. Inbox\n"
				+ "2. Mail to Admin\n"
				+ "3. Mail to another Client\n"
				+ "0. Back\n"
				+ ">> ");
	}
	
	public void buyNewTicketMenu() {
		System.out.print("1. Buy\n"
				+ "0. Back\n"
				+ ">> ");
	}
	
	// design
	
	public void emptyMenu() {
		/*
		System.out.println(""
				+ "--------------------------------------------\n"
				+ "|                                          |\n"
				+ "|                                          |\n"
				+ "|                  EMPTY                   |\n"
				+ "|                                          |\n"
				+ "|                                          |\n"
				+ "--------------------------------------------\n\n");
		}
		*/
		System.out.println("  E  M  P  T  Y\n");
	}
	
	public void ticketBuyErr() {
		System.out.println("Conditions not matched. Either no seat is free or insufficiant balance.");
	}
	
}
