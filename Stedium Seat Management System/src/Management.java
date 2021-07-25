import java.awt.Menu;

public class Management {
	public static void ManageMatch(Match match) {
		int choice;
		while(true) {
			System.out.print("\t\t==== Manage Match  ====\n\n" // ( Match ID : " + match.getId() + " )
					+ "1. Change description\n"
					+ "2. Change match type\n"
					+ "3. Change Match Day\n"
					+ "4. Change/modify vip seat number\n"
					+ "5. Change/modify normal seat numbers\n"
					+ "6. Change validity\n"
					+ "0. Exit \n>>");
			
			choice = Integer.parseInt(Database.scanner.nextLine());
			
			switch (choice) {
			case 0: {
				return;
			}
			
			case 1: {
				System.out.println("\t\t==== Current Description ====\n" + match.getDesciption());
				match.setDesciption(Tools.getInput("Enter new description"));
				break;
			}

			case 2: {
				System.out.println("Current match type : " + match.getMatchType());
				match.setMatchType(Tools.getInput("Enter new match type"));
				break;	
			}
			
			case 3: {
				System.out.println("Current match day : " + match.getMatchDay());
				match.setMatchDay(Tools.getInput("Enter new match Day"));
				break;	
			}
			
			case 4: {
				while(true) {
					do {
						System.out.println("\t\t==== Vip Seat Management (seat : " + match.getVipSeats() + " ) ====\n\n"
								+ "1. Add seat(s)\n"
								+ "2. Change total seat\n"
								+ "3. Remove seat\n"
								+ "4. Make empty\n"
								+ "0. Exit\n"
								+ " >> ");
						choice = Integer.parseInt(Database.scanner.nextLine());
					}while(!(choice >= 0 && choice < 5));
					
					if(choice == 4) {
						match.setVipSeats(0);
						System.out.println("Changed to 0");
						continue;
					}
					else if(choice == 0) {
						break;
					}
					
					System.err.print("Enter seat(s) (Current : " + match.getVipSeats() + ") : ");
					int seat = Integer.parseInt(Database.scanner.nextLine());
					
					if(seat < 0) {
						System.out.println("Failed to change");
						continue;
					}
					else if(choice == 1) {
						match.addVipSeats(seat);
					}
					else if(choice == 2) {
						match.setVipSeats(seat);
					}
					else if(choice == 3) {
						match.removeVipSeats(seat);
					}
	
					System.out.println("Successfully changed");
					continue;
				}
				break;
			}

			case 5: {
				while(true) {
					do {
						System.out.println("\t\t==== Normal Seat Management (seat : " + match.getNormalSeats() + " ) ====\n\n"
								+ "1. Add seat(s)\n"
								+ "2. Change total seat\n"
								+ "3. Remove seat\n"
								+ "4. Make empty\n"
								+ "0. Exit\n"
								+ " >> ");
						choice = Integer.parseInt(Database.scanner.nextLine());
					}while(!(choice >= 0 && choice < 5));
					
					if(choice == 4) {
						match.setNormalSeats(0);
						System.out.println("Changed to 0");
						continue;
					}
					else if(choice == 0) {
						break;
					}
					
					System.err.print("Enter seat(s) (Current : " + match.getNormalSeats() + ") : ");
					int seat = Integer.parseInt(Database.scanner.nextLine());
					
					
					if(seat < 0) {
						System.out.println("Failed to change");
						continue;
					}
					else if(choice == 1) {
						match.addNormalSeats(seat);
					}
					else if(choice == 2) {
						match.setNormalSeats(seat);
					}
					else if(choice == 3) {
						match.removeNormalSeats(seat);
					}
					
					System.out.println("Successfully changed");
					continue;
				}
				break;
			}
			
			case 6: {
				System.out.println("Current validity : " + match.getValid());
				System.out.println("\nany invalid input set auto invalid\n"
						+ "1. valid\n"
						+ "2. invalid\n >> ");
				
				choice = Integer.parseInt(Database.scanner.nextLine());
				if(choice == 1) match.setValid(true);
				else match.setValid(false);
				break;
			}
			default:
				System.out.println("Invalid choise... press enter to continue");
				Database.scanner.nextLine();
			}
			
		}
	}
	
	//
	
	
	public static void manageTicket(Ticket ticket) {
		int choice;
		
		while(true) {
			System.out.println("\t\t==== Ticket Manager ====\n\n"
					+ "1. Change ID (be careful)\n"
					+ "2. Change seat quantites\n"
					+ "3. Change Price\n"
					+ "0. Exit\n"
					+ ">> ");
			choice = Integer.parseInt(Tools.getInput(null));
			
			switch(choice) {
				case 0 :{
					return;
				}
				case 1 :{
					System.out.println("Current id is : " + ticket.getId());
					ticket.setId(Tools.getInput("Enter new id"));
					break;
				}
				case 2 :{
					System.out.println("Current seat available : " + ticket.getQuantities());
					ticket.setQuantities(Integer.parseInt(Tools.getInput("Enter new Quantites")));
					break;
				}
				case 3 :{
					System.out.println("Current price is : " + ticket.getPrice());
					ticket.setPrice(Double.parseDouble(Tools.getInput("Enter new price")));
					break;
				}
				default : {
					System.out.println("Invalid. Try again please");
				}
			}
		}
	}
	
	//
	
	public static void manageClient(Client client) {
		int choice;
		
		while(true) {
			
			System.out.println("\t\t ==== Manage Client ====\n\n");
			
			client.shortProfile();
			
			System.out.println(
					 "1. Change name\n"
					+ "2. Change Age\n"
					+ "3. Change Gender\n"
					+ "4. Change number\n"
					+ "5. Change Address\n"
					+ "6. Change Email\n"
					+ "7. Change Account Informations\n"
					+ "8. Manage Tickets\n"
					+ "0. Exit\n");
			
			Tools.selectMenu();
			
			choice = Integer.parseInt(Tools.getInput(null));
			
			switch (choice) {
				case 0:{
					return;
				}
				
				case 1:{
					System.out.println("Current Name : " + client.getName());
					client.setName(Tools.getInput("Enter new name"));
					break;
				}
				
				case 2:{
					System.out.println("Current Age : " + client.getAge());
					client.setAge(Integer.parseInt(Tools.getInput("Enter new age")));
					break;
				}
				
				case 3:{
					System.out.println("Current Gender : " + client.getGender());
					client.setGender(Tools.getInput("Enter new gender"));
					break;
				}
				
				case 4:{
					System.out.println("Current Number : " + client.getNumber());
					client.setNumber(Tools.getInput("Enter new number"));
					break;
				}
				
				case 5:{
					System.out.println("Current Address : " + client.getAddress());
					client.setAddress(Tools.getInput("Enter new Address"));
					break;
				}
				
				case 6:{
					System.out.println("Current Email : " + client.getEmail());
					client.setEmail(Tools.getInput("Enter new email"));
					break;
				}
				
				case 7:{
					
					Menu : while(true) {
						System.out.println("\t\t==== Manage Account (Available alance :" + client.getAccount().getBalance() + ")====\n\n"
								+ "1. Change Balance (sensitive)\n"
								+ "2. Withdrow Money\n"
								+ "0. Exit\n"
								+ ">> ");
						choice = Integer.parseInt(Tools.getInput(null));
						switch(choice) {
							case 0 :{
								break Menu;
							}
							
							case 1 :{
								System.out.println("Current Balance : " + client.getAccount().getBalance());
								client.getAccount().setBalance(Double.parseDouble(Tools.getInput("Enter new balance : ")));
								
								break;
							}
							
							case 2 :{
								
								client.getAccount().deposid(Double.parseDouble(Tools.getInput("Enter Deposit money")));
								
								break;
							}
						}
					}
					
					break;
				}
				
				case 8:{
					
					while(true) {
							client.showAllTickets();
							Tools.selectMenu();
							choice = Integer.parseInt(Tools.getInput(null));
							if(choice == 0) {
								break;
							}
							Ticket ticket;
							try {
								ticket = client.getTicket(choice-1);
								if(ticket == null) throw new Exception();
							}catch (Exception e) {
								System.out.println("Invalid choise.. Press enter to continue");
								Database.scanner.nextLine();
								continue;
							}
							
							Management.manageTicket(ticket);
						}
					
					break;
				}
				default :{
					System.out.println("Invalid choice");
				}

			}
		}
	}
	
	//
	
	
	public static boolean canBuy(Client client, double money) {
		if(client.getAccount().getBalance() >= money) {
			client.getAccount().removeBalance(money);
			return true;
		}
		return false;
	}
}
