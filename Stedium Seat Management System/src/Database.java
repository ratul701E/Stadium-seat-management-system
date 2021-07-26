import java.util.Scanner;

public class Database {
	public static Client clients[];
	public static Admin admins[];
	public static Match matches[];
	
	
	public static Scanner scanner = new Scanner(System.in);
	
	static {
		clients = new Client[200];
		admins = new Admin[200];
		matches = new Match[200];
	}
	
	// adds
	
	public static boolean addClient(Client client) {
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]== null ) {
				clients[i] = client; 
				return true;
			}
		}
		return false;
	}
	
	public static boolean addAdmin(Admin admin) {
		for(int i = 0; i < admins.length; i++) {
			if(admins[i]== null ) {
				admins[i] = admin;
				return true;
			}
		}
		return false;
	}
	
	// removes
	
	public static boolean removeClient(Client client) {
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]== client ) {
				clients[i] = null; 
				return true;
			}
		}
		return false;
	}
	
	public static boolean removeAdmin(Admin admin) {
		for(int i = 0; i < admins.length; i++) {
			if(admins[i]== admin ) {
				admins[i] = null; 
				return true;
			}
		}
		return false;
	}
	
	public static boolean addMatch(Match match) {
		for(int i = 0; i < matches.length; i++) {
			if(matches[i] == null ) {
				matches[i] = match;
				return true;
			}
		}
		return false;
	}
	
	public static boolean removeMatch(Match match) {
		for(int i = 0; i < matches.length; i++) {
			if(matches[i] == match ) {
				matches[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// shows
	
	public static void showAllMatches() {
		System.out.println("\t\t\t==== All Matches ====\n");
		for(int i = 0; i< matches.length; i++) {
			if(matches[i] != null ) {
				 System.out.print((i+1) + ". ");
				 matches[i].shortDetails();
			}
		}
	}
	
	
	
	// search
	
	public static int isExistUser(String username, String password) {
		for(int i = 0;  i < clients.length; i++) {
			if(clients[i]!= null ) {
				if(clients[i].getUsername().equals(username)) {
					if(password != null) {
						if(clients[i].getPassword().equals(password)) {
							return 2;
						}
						else return 1;
					}
					else return 1;
				}
			}
		}
		return 0;
	}
	
	
	
	
	
	// checks
	
	public static boolean isAdmin(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) {
			return true;
		}
		return false;
	}
	
	
	// menus
	
	
	
}
