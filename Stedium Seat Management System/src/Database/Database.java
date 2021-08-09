package Database;
import java.util.Scanner;
import Management.*;
import Menus.Menu;
import StediumStuffs.Match;
import Users.Admin;
import Users.Client;

public abstract class Database {
	public static Client clients[];
	public static Admin admins[];
	public static Match matches[];
	public static AdminFileHandler AdminfilerHandler;
	public static ClientFileHandler ClientfilerHandler;
	public static MatchFileHandler matchFileHandler;
	
	static {
		AdminfilerHandler = new AdminFileHandler("Database/source/admins.ser");
		ClientfilerHandler = new ClientFileHandler("Database/source/clients.ser");
		matchFileHandler = new MatchFileHandler("Database/source/matches.ser");
	}
	
	
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
		System.out.println(Menu.space + "==== All Matches ====\n");
		for(int i = 0; i< matches.length; i++) {
			if(matches[i] != null ) {
				 //System.out.print((i+1) + ". ");
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
		Tools.clear();
		System.out.println(Menu.space + "==== New Match ====\n\n");
		String id = Match.GeneratMatchId();
		
		System.out.println(Menu.space + "Match Id is : " + id);
		
		String description = Tools.getInput("Enter match description");
		String matchType = Tools.getInput("Enter match type");
		String matchDay = Tools.getInput("Enter match date");
		
		int vipseats = Tools.getInputI("Enter vip seat quantity");
		int vipseatCost = Tools.getInputI("Vip seat price");
		
		
		int normalseats = Tools.getInputI("Enter normal seat quantity");
		int normalseatCost = Tools.getInputI("Normal seat price");
		
		//String id, String matchDay, String description, String matchType, int vipSeats, int normalSeats, int vipCost, int normalCost
		
		boolean confirmation = Database.addMatch(new Match(id,matchDay,description,matchType,vipseats,normalseats,vipseatCost,normalseatCost));
		
		Tools.clear();
		
		if(confirmation) {
			System.out.println(Menu.space + "Match Added");
		}else {
			System.out.println(Menu.space + "Match cannot be added. Maybe storage is full");
		}
		
		Tools.etoc();
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
	
	// file reader writer
	
	public static void  saveData() {
		AdminfilerHandler.write(admins);
		ClientfilerHandler.write(clients);
		matchFileHandler.write(matches);
		
		Tools.sleepFor("Saving ",4);
	}
	
	public static void restoreData() {
		admins =  AdminfilerHandler.read();
		clients =  ClientfilerHandler.read();
		matches = matchFileHandler.read();
		
		Tools.sleepFor("Fetching data ", 4);
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
