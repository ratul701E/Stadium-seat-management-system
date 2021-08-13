/*
 * Asiya Akter writes this class
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
				+ space + "1. My Tickets\n"
				+ space + "2. Buy Tickets\n"
				+ space + "3. Cancelled Tickets\n"
				+ space + "4. Purchase History\n"
				+ space + "5. Change Username and Password\n"
				+ space + "6. Account Balance\n"
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
				System.out.print(space + "5. Change Username and Password\n"
				+ space + "0. Logout\n"
				+ "\n" + space + " >> ");
	}
	
	
	
	public void matchControlMenu() {
		System.out.print(space + "==== Manage Match  ====\n\n" // ( Match ID : " + match.getId() + " )
				+ space + "1. Change Description\n"
				+ space + "2. Change Match type\n"
				+ space + "3. Change Match Day\n"
				+ space + "4. Change/modify vip seat number\n"
				+ space + "5. Change/modify normal seat numbers\n"
				+ space + "6. Change Validity\n"
				+ space + "7. Remove Match\n"
				+ space + "0. Exit \n"
				+ "\n" + space + "  >> "); 
	}
	
	public void vipSeatManage(int seats) {
		System.out.print(space + "==== Vip Seat Management (seat : " + seats + " ) ====\n\n"
				+ space + "1. Add Seat(s)\n"
				+ space + "2. Change Total seat\n"
				+ space + "3. Remove Seat\n"
				+ space + "4. Make Empty\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void normalSeatManage(int seats) {
		System.out.print(space + "==== Normal Seat Management (seat : " + seats + " ) ====\n\n"
				+ space + "1. Add Seat(s)\n"
				+ space + "2. Change Total Seat\n"
				+ space + "3. Remove Seat\n"
				+ space + "4. Make Empty\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public  void selectMenu() {
		//System.out.println("\n\t\tSelect one to modify");
		System.out.print("\n" + space + "  >> ");
	}
	
	
	public void clientManagementMenu() {
		System.out.println(
				  space + "1. Change Name\n"
				+ space + "2. Change Age\n"
				+ space + "3. Change Gender\n"
				+ space + "4. Change Number\n"
				+ space + "5. Change Address\n"
				+ space + "6. Change Email\n"
				+ space + "7. Manage Account\n"
				+ space + "8. Manage Tickets\n"
				+ space + "9. Remove Client\n"
				+ space + "0. Exit\n");
	}
	
	
	public void accountManageMenu(double balance) {
		System.out.print(space + "==== Manage Account ( Available Balance : " + balance + " )====\n\n"
				+ space + "1. Change Balance (sensitive)\n"
				+ space + "2. Deposit Money\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void ticketManageMenu() {
		System.out.print(space + "==== Ticket Manager ====\n\n"
				+ space + "1. Change ID (be careful)\n"
				+ space + "2. Change Seat Quantites\n"
				+ space + "3. Change Price\n"
				+ space + "0. Exit\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void loginMenu() {
		System.out.print(space + "==== Log in Menu ====\n\n"
				+ space + "1. Client Login\n"
				+ space + "2. Admin Login\n"
				+ space + "0. Back\n"
				+ "\n" + space + "  >> ");
	}
	
	
	public void portalMenu() {
		//Tools.clear();
		System.out.print(space + "==== Stadium Portal ====\n\n"
				+ space + "1. Login\n"
				+ space + "2. Create an Account\n"
				+ space + "3. Contributions\n"
				+ space + "4. About Us\n"
				+ space + "0. Stop Server\n"
				+ "\n" + space + "  >> ");
	}
	
	public void mailMenu(boolean isNewMail) {
		System.out.print(space + "==== Mail ====\n\n"
				+ space + "1. Inbox");
		
		if(isNewMail) System.out.println("   (New!)");
		else System.out.println();
		
				System.out.print(space + "2. Mail to Admin\n"
				+ space + "3. Mail to Another Client\n"
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
		Tools.clearPrintHold("     E  M  P  T  Y\n");
	}
	
	public void ticketBuyErr() {
		Tools.clearPrintHold("Conditions not matched. Either no seat is free or insufficiant balance.");
	}
	
}
