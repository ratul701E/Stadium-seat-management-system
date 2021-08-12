/*
 * This class is written by Asiya Akter
 * Id : 21-44386-1
 * 
 */

package Menus;

import Management.Tools;

public class Menu {
	
	public static String space = "                                                     ";
	
	public static Menu menus = new Menu();
	
	
	public Menu() {}
	
	public void clientInterface(boolean newMails) {
		System.out.print(space + "==== Client ====\n\n"
				+ space + "1. My tickets\n"
				+ space + "2. Buy tickets\n"
				+ space + "3. Cancelled tickets\n"
				+ space + "4. Purchase history\n"
				+ space + "5. Change username and password\n"
				+ space + "6. Account information\n"
				+ space + "7. Mail");
		
		if(newMails) {
			System.out.println("  (new!)");
		}else {
			System.out.println();
		}
				
				System.out.print(space + "0. Logout\n"
				+ "\n" + space + "  >> ");
	}
	
	public void adminInterface(boolean newMails) {
		System.out.print(space + "==== Admin Panel ====\n\n"
				+ space + "1. Add Match\n"
				+ space + "2. Manage Match\n"
				+ space + "3. Manage Clients\n"
				+ space + "4. Mail");
		if(newMails) {
			System.out.println("  (new!)");
		}else {
			System.out.println();
		}
				System.out.print(space + "5. Change username and password\n"
				+ space + "0. Logout\n"
				+ "\n" + space + " >> ");
	}
	
	
	
	public void matchControlMenu() {
		System.out.print(space + "==== Manage Match  ====\n\n" // ( Match ID : " + match.getId() + " )
				+ space + "1. Change description\n"
				+ space + "2. Change match type\n"
				+ space + "3. Change Match Day\n"
				+ space + "4. Change/modify vip seat number\n"
				+ space + "5. Change/modify normal seat numbers\n"
				+ space + "6. Change validity\n"
				+ space + "7. Remove match\n"
				+ space + "0. Exit \n"
				+ "\n" + space + "  >> "); 
	}
	
	public void vipSeatManage(int seats) {
		System.out.print(space + "==== Vip Seat Management (seat : " + seats + " ) ====\n\n"
				+ space + "1. Add seat(s)\n"
				+ space + "2. Change total seat\n"
				+ space + "3. Remove seat\n"
				+ space + "4. Make empty\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void normalSeatManage(int seats) {
		System.out.print(space + "==== Normal Seat Management (seat : " + seats + " ) ====\n\n"
				+ space + "1. Add seat(s)\n"
				+ space + "2. Change total seat\n"
				+ space + "3. Remove seat\n"
				+ space + "4. Make empty\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public  void selectMenu() {
		//System.out.println("\n\t\tSelect one to modify");
		System.out.print("\n" + space + "  >> ");
	}
	
	
	public void clientManagementMenu() {
		System.out.println(
				  space + "1. Change name\n"
				+ space + "2. Change Age\n"
				+ space + "3. Change Gender\n"
				+ space + "4. Change number\n"
				+ space + "5. Change Address\n"
				+ space + "6. Change Email\n"
				+ space + "7. Account details\n"
				+ space + "8. Manage Tickets\n"
				+ space + "9. Remove client\n"
				+ space + "0. Exit\n");
	}
	
	
	public void accountManageMenu(double balance) {
		System.out.print(space + "==== Manage Account (Available Balance : " + balance + ")====\n\n"
				+ space + "1. Change Balance (sensitive)\n"
				+ space + "2. Deposit Money\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void ticketManageMenu() {
		System.out.print(space + "==== Ticket Manager ====\n\n"
				+ space + "1. Change ID (be careful)\n"
				+ space + "2. Change seat quantites\n"
				+ space + "3. Change Price\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void loginMenu() {
		System.out.print(space + "==== Log in Menu ====\n\n"
				+ space + "1. Client login\n"
				+ space + "2. Admin login\n"
				+ space + "0. Back\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void portalMenu() {
		//Tools.clear();
		System.out.print(space + "==== Stadium Portal ====\n\n"
				+ space + "1. Login\n"
				+ space + "2. Create an account\n"
				+ space + "3. Contributions\n"
				+ space + "4. About us\n"
				+ space + "0. Stop server\n"
				+ "\n" + space + "  >> ");
	}
	
	public void mailMenu(boolean isNewMail) {
		System.out.print(space + "==== Mail ====\n\n"
				+ space + "1. Inbox");
		
		if(isNewMail) System.out.println("   (New!)");
		else System.out.println();
		
				System.out.print(space + "2. Mail to Admin\n"
				+ space + "3. Mail to another Client\n"
				+ space + "0. Back\n"
				+ "\n" + space + "  >> ");
	}
	
	public void buyNewTicketMenu() {
		System.out.print(space + "        1. Buy\n"
				+ space + "        0. Back\n"
				+ "\n" + space + "          >> ");
	}
	
	
	// popup
	
	public void popup(String message) {
		Tools.clearPrintHold(message);
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
		Tools.clearPrintHold("    E  M  P  T  Y\n");
	}
	
	public void ticketBuyErr() {
		Tools.clearPrintHold("Conditions not matched. Either no seat is free or insufficiant balance.");
	}
	
}
