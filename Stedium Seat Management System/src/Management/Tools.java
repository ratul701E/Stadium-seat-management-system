/*
 * This class is written by Rianul Amin Rian
 * Id : 21-44589-1
 * 
 */
package Management;

import java.io.IOException;
import Database.Database;
import Menus.Menu;

public abstract class Tools {
	
	public static String getInput(String message) {
		/*
		 * this method will take a input from user and return. If input is empty then it will show a warning and again ask for input
		 */
		while(true) {
			if(message != null) {
				System.out.print(Menu.space + message + " : ");
			}
			
			String returnValue = Database.scanner.nextLine();
			if(returnValue.isEmpty()) {
				System.out.print(Menu.space + "This field cannot empty. Try Again");
				System.out.print(Menu.space +  "  >> ");
				continue;
			}
			return returnValue;
		}
	}
	
	
	public static int getInputI(String message) {
		/*
		 * This method will take a string from user and convert to integer. If any exception happened then it will ask again for input.
		 */
		while(true) {
			if(message != null) System.out.print(Menu.space + message + " : ");
			String returnValue = Database.scanner.nextLine();
			
			try {
				return Integer.parseInt(returnValue);
			}catch(NumberFormatException err){
				System.out.print(Menu.space + "This field dosen't suppot this kind of data");
				System.out.print("\n" + Menu.space +  "  >> ");
				continue;
			}
		}
	}
	
	public static double getInputD(String message) {
		/*
		 * This method will take a string from user and convert to double. If any exception happened then it will ask again for input.
		 */
		if(message != null) System.out.print(Menu.space + message + " : ");
		while(true) {
			String returnValue = Database.scanner.nextLine();
			
			try {
				return Double.parseDouble(returnValue);
			}catch(NumberFormatException err){
				System.out.print(Menu.space + "This field dosen't suppot this kind of data");
				System.out.print("\n" + Menu.space +  "  >> ");
				continue;
			}
		}
	}
	
	public static void etoc() {
		/*
		 * This method will stop the screen and wait for press enter button
		 */
		System.out.println(Menu.space + "Press enter to continue. . .");
		Database.scanner.nextLine();
	}
	
	
	public static void clear() {
		/*
		 * This method will clear the whole screen.
		 */
	
		 try {
			new ProcessBuilder("cmd", "/c", "clear").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void clearPrintHold(String message) {
		/*
		 * This method will clear the screen then show a message and wait until user press enter.
		 */
		Tools.clear();
		System.out.println("\n\n\n\n" + Menu.space + message);
		Tools.etoc();
		Tools.clear();
	}
	
	
	public static void sleepFor(String message, int sec){
		/*
		 * This method will show a message for certain time by stopping main thread.
		 */
		try{
			Tools.clear();
			System.out.print("\n\n\n\n" + Menu.space + message);
			for(int i = 0; i < sec; i++){
				System.out.print(".");
				Thread.sleep(1000);
			}
			Tools.clear();
		}catch(Exception e){
			// pass
		}
	}
	
	

}
