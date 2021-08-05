package Management;

import Database.Database;

public class Tools {
	
	public static String getInput(String message) {
		while(true) {
			if(message != null) System.out.print(message + " : ");
			
			String returnValue = Database.scanner.nextLine();
			if(returnValue.isEmpty()) {
				System.err.print("This field cannot be empty. Try again");
				continue;
			}
			return returnValue;
		}
	}
	
	
	public static int getInputI(String message) {
		while(true) {
			if(message != null) System.out.print(message + " : ");
			String returnValue = Database.scanner.nextLine();
			
			try {
				return Integer.parseInt(returnValue);
			}catch(NumberFormatException err){
				System.out.print("Enter a valid input please\n"
						+ ">> ");
				continue;
			}
		}
	}
	
	public static double getInputD(String message) {
		while(true) {
			if(message != null) System.out.print(message + " : ");
			String returnValue = Database.scanner.nextLine();
			
			try {
				return Double.parseDouble(returnValue);
			}catch(NumberFormatException err){
				System.out.print("Enter a valid input please\n"
						+ ">> ");
				continue;
			}
		}
	}
	
	public static void etoc() {
		System.out.println("Press enter to continue. . .");
		Database.scanner.nextLine();
	}
	
	
	public static void clear() {
	    System.out.print("\033[H\033[2J");   
	    System.out.flush();   

	}
	
	
	
	//menus
	

}
