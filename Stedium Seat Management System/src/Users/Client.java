package Users;
import Interfaces.IClientInterface;
import Menus.Menu;
import StediumStuffs.Account;
import StediumStuffs.Mail;
import StediumStuffs.Match;
import StediumStuffs.Notification;
import StediumStuffs.Ticket;

/*
 * This class is written by Asraful Alam Ratul
 * ID : 21-44588-1
 * 
 */

public class Client extends Person implements IClientInterface{
	private String username;
	private String password;
	private String email;
	private boolean isDisable;
	private boolean newMails;
	private Account account;
	private Mail mails[];
	private Notification notifications[];
	private Ticket tickets[];
	private Ticket cancelledTickets[];
	private Match upcomingMatches[];
	private Ticket purchaseHistory[];
	
	
	// ------------------------- constructors
	
	public Client(){
		
	}
	
	public Client(String name, int age, String gender, String number, String address, String email,String username, String password, Account account){
		super(name,age,gender,number,address);
		this.email = email;
		this.mails = new Mail[size];
		this.notifications = new Notification[size];
		this.tickets = new Ticket[size];
		this.cancelledTickets = new Ticket[size];
		this.upcomingMatches = new Match[size];
		this.purchaseHistory = new Ticket[size];
		this.isDisable = false;
		this.account = account;
		this.username = username;
		this.password = password;
		this.newMails = false;
	}
	
	
	// ------------------------- sets
	
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}
	
	public void setNewMails(boolean newMails) {
		this.newMails = newMails;
	}
	
	// ------------------------- gets
	
	
	public String getEmail() {
		return email;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getDisable() {
		return isDisable;
	}
	
	public Ticket getTicket(int index) {
		return tickets[index];
	}
	
	public Mail[] getAllMails() {
		return mails;
	}
	
	public boolean newMails() {
		return newMails;
	}
	
	// lists
	
	public void showAllTickets() {
		if(this.countTickets() == 0) {
			Menu.menus.emptyMenu();
			return;
		}
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i] != null) {
				System.out.print((i+1) + ". ");
				System.out.printf("ID : %-10s\t%-10d\n", tickets[i].getId(), tickets[i].getQuantities());
			}
		}
	}
	
	
	public Ticket[] getCancelledTickets() {
		return cancelledTickets;
	}
	
	public Ticket[] getPurchasedTickets() {
		return purchaseHistory;
	}
	// ------------------------- adds
	
	
	public boolean addMail(Mail mail) {
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
	
	public boolean addTicket(Ticket ticket) {
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i]== null ) {
				tickets[i] = ticket;
				return true;
			}
		}
		return false;
	}
	
	public boolean addToCancelledTicket(Ticket ticket) {
		for(int i = 0; i < cancelledTickets.length; i++) {
			if(cancelledTickets[i]== null ) {
				cancelledTickets[i] = ticket;
				return true;
			}
		}
		return false;
	}
	
	public boolean addToUpcomingMatches(Match match) {
		for(int i = 0; i < upcomingMatches.length; i++) {
			if(upcomingMatches[i]== null ) {
				upcomingMatches[i] = match;
				return true;
			}
		}
		return false;
	}
	
	public boolean addToPurchaseHistory(Ticket ticket) {
		for(int i = 0; i < purchaseHistory.length; i++) {
			if(purchaseHistory[i]== null ) {
				purchaseHistory[i] = ticket;
				return true;
			}
		}
		return false;
	}
	
	
	// ------------------------- removes
	
	
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
			if(notifications[i]== null ) {
				notifications[i] = notification;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeTicket(Ticket ticket) {
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i]== ticket ) {
				tickets[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeFormCancelledTicket(Ticket ticket) {
		for(int i = 0; i < cancelledTickets.length; i++) {
			if(cancelledTickets[i]== ticket ) {
				cancelledTickets[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeFormUpcomingMatches(Match match) {
		for(int i = 0; i < upcomingMatches.length; i++) {
			if(upcomingMatches[i]== match ) {
				upcomingMatches[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeFormPurchaseHistory(Ticket ticket) {
		for(int i = 0; i < purchaseHistory.length; i++) {
			if(purchaseHistory[i]== ticket ) {
				purchaseHistory[i] = null;
				return true;
			}
		}
		return false;
	}
	
	
	// search
	
	public Ticket searchTicket(String id) {
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i]!= null ) {
				if(tickets[i].getId().equals(id)) {
					return tickets[i];
				}
			}
		}
		return null;
	}
	
	// counts
	
	public int countTickets() {
		int count = 0;
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i]!= null ) {
				count++;
			}
		}
		
		return count;
	}
	
	public int countAllMails() {
		int count = 0;
		for(int i = 0; i < mails.length; i++) {
			if(mails[i]!= null ) {
				count++;
			}
		}
		return count;
	}
	
	public int countCancelldTickets() {
		int count = 0;
		for(int i = 0; i < cancelledTickets.length; i++) {
			if(cancelledTickets[i]!= null ) {
				count++;
			}
		}
		
		return count;
	}
	
	public int countPurchedTickets() {
		int count = 0;
		for(int i = 0; i < purchaseHistory.length; i++) {
			if(purchaseHistory[i]!= null ) {
				count++;
			}
		}
		
		return count;
	}
	
	// shows
	
	public void shortProfile() {
		System.out.println(Menu.space + "Username : " + username);
		System.out.println(Menu.space + "Name : " + getName());
		System.out.println(Menu.space + "Age : " + getAge());
		System.out.println(Menu.space + "Gender : " + getGender());
		System.out.println(Menu.space + "Address : " + getAddress());
		System.out.println(Menu.space + "Email : " + email);
		System.out.println("\n");
	}
}