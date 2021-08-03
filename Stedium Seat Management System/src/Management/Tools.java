package Management;
import java.io.IOException;

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
	
	
	public static void etoc() {
		System.out.println("Press enter to continue. . .");
		Database.scanner.nextLine();
	}
	
	
	public static void clear() {
		/*
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	
	
	
	//menus
	

}
