package Users;
import Database.Database;
import Interfaces.IAdminInterface;
import Management.Management;
import Management.Tools;
import Menus.Menu;
import StediumStuffs.Feedback;
import StediumStuffs.Mail;
import StediumStuffs.Match;
import StediumStuffs.Notification;

/*
 * This class is written by Asraful Alam Ratul
 * ID : 21-44588-1
 * 
 */

public class Admin extends Person implements IAdminInterface{
	private String email;
	private String username;
	private String password;
	private static boolean newMails;
	private static Feedback feedbacks[];
	private static Mail mails[];
	private static Notification notifications[];
	
	
	
	static {
		
		mails = new Mail[size];
		feedbacks = new Feedback[size];
		notifications = new Notification[size];
		newMails = false;
	}
	
	
	// ------------------------- constructors
	
	
	public Admin() {
		
	}
	
	public Admin(String name, int age, String gender, String number, String address, String email, String username, String password) {
		super(name,age,gender,number,address);
		this.email = email;
		this.username = username;
		this.password = password;
		
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
	
	public static void setNewMails(boolean nMails) {
		newMails = nMails;
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
	
	public Mail[] getAllMails() {
		return mails;
	}
	
	public boolean newMails() {
		return newMails;
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
	
	public static boolean addMail(Mail mail) {
		newMails = true;		
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
	
	
	/*
	public void manageTickets() {
		
		//Management.manageTicket(null);
	}
	*/
	
	
	public void manageClients() {

	}
	
	public void manageMatches() {
		while(true) {
			int choice;
			Database.showAllMatches();
			System.out.println("0. Exit");
			
			Menu.menus.selectMenu();
			
			choice = Integer.parseInt(Tools.getInput(""));
			if(choice == 0) return;
			Match match;
			
			try {
				match = Database.matches[choice-1];
				if(Database.matches[choice-1] == null) throw new Exception();
			}catch (Exception e) {
				
				Tools.etoc();
				
				continue;
			}
			
			Management.ManageMatch(match);
			
		}
		
	}
	
	public void addMatch() {
		Database.createMatch();
	}
	
	
	// ------------------------- useful functions
	
	
	public void showAllMails() {
		for(int i = 0; i< mails.length; i++) {
			
		}
	}
	
	// counts
	
	
	public int countAllMails() {
		int count = 0;
		for(int i = 0; i < mails.length; i++) {
			if(mails[i]!= null ) {
				count++;
			}
		}
		return count;
	}

	
}
