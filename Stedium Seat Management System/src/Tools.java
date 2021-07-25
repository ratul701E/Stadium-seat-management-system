
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
	
	
	
	
	
	
	
	//menus
	
	public static void selectMenu() {
		System.out.println("\nSelect one to modify");
		System.out.print("_exit key 0_ >> ");
	}
}
