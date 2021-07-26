
public class Start {

	public static void main(String[] args) {
		Admin admin = new Admin("name", 10, "gender", "number","address", "email", 100);
		
		
		Match match1 = new Match("Cricket", 5,10,"27 oct 2021");
		Match match2 = new Match("Football", 20,100,"4 oct 2021");
		Match match3 = new Match("Tennis", 50,150,"8 oct 2021");
		Match match4 = new Match("Footbal", 2,70,"22 oct 2021");
		Match match5 = new Match("Football", 40,80,"6 oct 2021");
		Match match6 = new Match("Football", 30,90,"12 oct 2021");
		Match match7 = new Match("Football", 30,90,"12 oct 2021");
		
		
		Database.addMatch(match1);
		Database.addMatch(match2);
		Database.addMatch(match3);
		Database.addMatch(match4);
		Database.addMatch(match5);
		Database.addMatch(match6);
		Database.addMatch(match7);
		
		Client c1 = new Client("Ratul", 20, "Male", "01920221554", "Nandipara", "Ratul@gamil.com","dd","aa", new Account(0), 20);
		Client c2 = new Client("Priya", 20, "Female", "017.......23", "Gazipur", "Priya@gamil.com","dd","aa", new Account(0) ,20);
		
		//Ticket t1 = new Ticket("2136", 5, 550,1);
		//c2.addTicket(t1);
		
		//admin.manageMatches();
		//Management.manageClient(c1);
		
		Group1Stedium.signup();
		Group1Stedium.signup();
		Group1Stedium.login();
		

	}

}
