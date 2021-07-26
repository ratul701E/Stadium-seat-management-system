
public class Group1Stedium {
	
	
	public void startServer() {
		
	}
	
	
	
	
	private void login() {
		
		while(true) {
			System.out.println("\t\t==== Log in Menu ====\n\n"
					+ "1. Client login\n"
					+ "2. Admin login\n"
					+ ">> ");
			
			int choice = Integer.parseInt(Tools.getInput(null));
			
			switch (choice) {
				case 1: {
					String username, password;
					username = Tools.getInput("Username");
					password = Tools.getInput("Password");
					
					if(Database.isExistUser(username, password) == 2) {
						// access user
					}else if(Database.isExistUser(username, password) == 1) {
						System.out.println("Invalid password");
					}else {
						System.out.println("No user found");
					}
					
					break;
				}
				
				case 2: {
					
					if(Database.isAdmin(Tools.getInput("Username"), Tools.getInput("Password"))) {
						//acces admin
					}
					
				}
			}
		}
	}
	
	//
	
	
	private void signup() {
		String name, gender, number, address, email, username, password;
		
		int age;
		System.out.println("\t\t==== Signup Page ====\n");
		
		name = Tools.getInput("Enter your name*");
		age = Integer.parseInt(Tools.getInput("Enter your age*"));
		gender = Tools.getInput("Enter your gender*");
		number = Tools.getInput("Enter your number*");
		address = Tools.getInput("Enter your address*");
		email = Tools.getInput("Enter your email*");
		
		while(true) {
			username = Tools.getInput(("Enter your username* : "));
			if(Database.isExistUser(username, null) == 0) {
				break;
			}
			System.out.println("username is taken.. try diffrent name please");

		}
		
		password = Tools.getInput("Enter your password");
		
		Database.addClient(new Client(name,age,gender,number,address,email,new Account(500), 200));
		System.out.println("Account created successfully");
		
		// enter to continue
		
		
	}
	
	
	private Ticket bookTicket(Client client, Match match) {
		Ticket ticket;
		
		
		
		System.out.println("\t\t==== Welcome to Ticket Counter====\n\n");
		match.fullDetails();
		
		System.out.println("1. Vip\n"
				+ "2. Normal\n"
				+ "0. Cancel\n"
				+ ">> ");
		
		int choice = Integer.parseInt(Tools.getInput(null));
		
		switch(choice) {
			case 0:{
				return null;
			}
			
			case 1:{
				int seatCount = Integer.parseInt(Tools.getInput("How many seat you want"));
				
				if(Management.canBuy(client, match.getVipCost()*seatCount)) {
					return new Ticket(match.getId(), seatCount, seatCount*match.getVipCost(),1);
				}
				break;
			}
			
			case 2:{
				int seatCount = Integer.parseInt(Tools.getInput("How many seat you want"));
				
				if(Management.canBuy(client, match.getNormalCost()*seatCount)) {
					return new Ticket(match.getId(), seatCount, seatCount*match.getNormalCost(),2);
				}
				break;
			}
			
			default:{
				System.out.println("Error");
			}
			
		}
		return null;
		
	}
}
