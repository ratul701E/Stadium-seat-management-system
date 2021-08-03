package Database;
import java.util.Scanner;
import Management.*;

import StediumStuffs.Match;
import Users.Admin;
import Users.Client;

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
	
	public static void showAllClients() {
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]!= null) {
				clients[i].shortProfile();
			}
		}
	}
	
	
	
	// search
	
	public static int isExistClinet(String username, String password) {
		for(int i = 0;  i < clients.length; i++) {
			if(clients[i]!= null ) {
				if(clients[i].getUsername().equals(username)) {
						if(clients[i].getPassword().equals(password)) {
							return 2;
						}
						else return 1;
				}
			}
		}
		return 0;
	}
	
	
	public static Client getClinet(String username) {
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]!= null ) {
				if(clients[i].getUsername().equals(username)) {
					return clients[i];
				}
			}
		}
		return null;
	}
	
	public static Admin getAdmin(String username) {
		for(int i = 0; i < admins.length; i++) {
			if(admins[i]!= null ) {
				if(admins[i].getUsername().equals(username)) {
					return admins[i];
				}
			}
		}
		return null;
	}
	
	
	// checks
	
	public static boolean isAdmin(String username, String password) {
		for(int i = 0; i < admins.length; i++) {
			if(admins[i] != null ) {
				if(admins[i].getUsername().equals(username) && admins[i].getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static boolean isUsernameExist(String username) {
		for(int i =0; i < clients.length; i++) {
			if(clients[i] != null ) {
				if(clients[i].getUsername().equals(username)) {
					return true;
				}
			}
		}
		return false;
	}
	
	// taking information
	
	public static void createMatch() {
		System.out.println("\t\t==== New Match ====\n\n");
		String id;
		
		do {
			id = Tools.getInput("Enter match id (unique id req)");
			//check id is available or not
		}while(false);
		
		String description = Tools.getInput("Enter match description");
		String matchType = Tools.getInput("Enter match type");
		String matchDay = Tools.getInput("Enter match date");
		
		int vipseats = Integer.parseInt(Tools.getInput("Enter vip seat quantity"));
		int vipseatCost = Integer.parseInt(Tools.getInput("Vip seat price"));
		
		
		int normalseats = Integer.parseInt(Tools.getInput("Enter normal seat quantity"));
		int normalseatCost = Integer.parseInt(Tools.getInput("Normal seat price"));
		
		//String id, String matchDay, String description, String matchType, int vipSeats, int normalSeats, int vipCost, int normalCost
		
		boolean confirmation = Database.addMatch(new Match(id,matchDay,description,matchType,vipseats,normalseats,vipseatCost,normalseatCost));
		if(confirmation) {
			System.out.println("Match Added");
		}else {
			System.out.println("Match cannot be added. Maybe storage is full");
		}
	}
	
	
	// searches
	
	public static Match searchMatch(String id) {
		for(int i = 0; i < matches.length;  i++) {
			if(matches[i] != null ) {
				if(matches[i].getId().equals(id)) {
					return matches[i];
				}
			}
		}
		return null;
	}
	
	public static Client searchByEmail(String email) {
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]!= null ) {
				if(clients[i].getEmail().equals(email)) {
					return clients[i];
				}
			}
		}
		return null;
	}
	
	
	// counts
	public int countClients() {
		int count = 0;
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]!= null ) {
				count++;
			}
		}
		
		return count;
	}
	
	public int countMatch() {
		int count = 0;
		for(int i = 0; i < matches.length; i++) {
			if(matches[i]!= null ) {
				count++;
			}
		}
		
		return count;
	}
	
	
}
