/*
 * This class is written by Asraful Alam Ratul
 * ID : 21-44588-1
 * 
 */

public class Admin extends Person{
	private String email;
	private String username;
	private String password;
	private static Feedback feedbacks[];
	private static Mail mails[];
	private static Notification notifications[];
	
	
	
	// ------------------------- constructors
	
	
	public Admin() {
		
	}
	
	public Admin(String name, int age, String gender, String number, String address, String email, int size) {
		super(name,age,gender,number,address);
		this.email = email;
		this.mails = new Mail[size];
		this.feedbacks = new Feedback[size];
		this.notifications = new Notification[size];
	}
	
	
	// ------------------------- sets
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	// ------------------------- sets
	
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	// ------------------------- adds
	
	
	
	public boolean addFeedbacks(Feedback feedback) {
		for(int i = 0; i < feedbacks.length; i++) {
			if(feedbacks[i] == null ) {
				feedbacks[i] = feedback;
				return true;
			}
		}
		return false;
	}
	
	public boolean addMail(Mail mail) {
		for(int i = 0; i < mails.length; i++) {
			if(mails[i]== null ) {
				mails[i] = mail;
				return true;
			}
		}
		return false;
	}
	
	public boolean addNotification(Notification notification) {
		for(int i = 0; i < notifications.length; i++) {
			if(notifications[i]== null ) {
				notifications[i] = notification;
				return true;
			}
		}
		return false;
	}
	
	
	// ------------------------- removes
	
	
	
	
	public boolean removeFeedbacks(Feedback feedback) {
		for(int i = 0; i < feedbacks.length; i++) {
			if(feedbacks[i] == feedback ) {
				feedbacks[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeMail(Mail mail) {
		for(int i = 0; i < mails.length; i++) {
			if(mails[i]== mail ) {
				mails[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeNotification(Notification notification) {
		for(int i = 0; i < notifications.length; i++) {
			if(notifications[i] == null ) {
				notifications[i] = notification;
				return true;
			}
		}
		return false;
	}
	
	
	// ------------------------- managements
	
	
	public void manageTickets() {
		
	}
	
	public void manageClients() {

	}
	
	public void manageMatches() {
		while(true) {
			int choice;
			Database.showAllMatches();
			System.out.println("0. Exit");
			
			Tools.selectMenu();
			
			choice = Integer.parseInt(Tools.getInput(""));
			if(choice == 0) return;
			Match match;
			
			try {
				match = Database.matches[choice-1];
				if(Database.matches[choice-1] == null) throw new Exception();
			}catch (Exception e) {
				System.out.println("Invalid choise.. Press enter to continue");
				Database.scanner.nextLine();
				continue;
			}
			
			Management.ManageMatch(match);
			
		}
		
	}
	
	
	// ------------------------- useful functions
	
	
	public void showAllMails() {
		for(int i = 0; i< mails.length; i++) {
			
		}
	}
	

	
}
