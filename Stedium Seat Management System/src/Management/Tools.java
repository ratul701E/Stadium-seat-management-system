package Management;

import java.io.IOException;

import Database.Database;
import Menus.Menu;

public class Tools {
	
	public static String getInput(String message) {
		while(true) {
			if(message != null) System.out.print(Menu.space + message + " : ");
			
			String returnValue = Database.scanner.nextLine();
			if(returnValue.isEmpty()) {
				System.err.print(Menu.space + "This field cannot be empty. Try again\n"
						+ Menu.space +  "  : ");
				continue;
			}
			return returnValue;
		}
	}
	
	
	public static int getInputI(String message) {
		while(true) {
			if(message != null) System.out.print(Menu.space + message + " : ");
			String returnValue = Database.scanner.nextLine();
			
			try {
				return Integer.parseInt(returnValue);
			}catch(NumberFormatException err){
				System.out.print(Menu.space + "Enter a valid input please\n"
						+ Menu.space + ">> ");
				continue;
			}
		}
	}
	
	public static double getInputD(String message) {
		if(message != null) System.out.print(Menu.space + message + " : ");
		while(true) {
			String returnValue = Database.scanner.nextLine();
			
			try {
				return Double.parseDouble(returnValue);
			}catch(NumberFormatException err){
				System.out.print(Menu.space + "Enter a valid input please\n"
						+  Menu.space + ">> ");
				continue;
			}
		}
	}
	
	public static void etoc() {
		System.out.println(Menu.space + "Press enter to continue. . .");
		Database.scanner.nextLine();
	}
	
	
	public static void clear() {
		/*
	    System.out.print("\033[H\033[2J");   
	    System.out.flush();  
	    */
		
		 try {
			new ProcessBuilder("cmd", "/c", "clear").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		/*
		for(int clear = 0; clear < 1000; clear++)
		  {
		     System.out.println("\b") ;
		  }
		  */

	}
	
	public static void clearPrintHold(String message) {
		Tools.clear();
		System.out.println(Menu.space + message);
		Tools.etoc();
	}
	
	
	
	//menus
	

}
