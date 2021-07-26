
/*
 * This class is written by Asraful Alam Ratul
 * ID : 21-44588-1
 * 
 */

public class Client extends Person{
	private String username;
	private String password;
	private String email;
	private boolean isDisable;
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
	
	public Client(String name, int age, String gender, String number, String address, String email, Account account,int size){
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
	
	
	// lists
	
	public void showAllTickets() {
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i] != null) {
				System.out.print((i+1) + ". ");
				System.out.printf("ID : %-10s\t%-10d\n", tickets[i].getId(), tickets[i].getQuantities());
			}
		}
	}
	
	// ------------------------- adds
	
	
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
	
	
	// shows
	
	public void shortProfile() {
		System.out.println("Name : " + getName());
		System.out.println("Age : " + getAge());
		System.out.println("Gender : " + getGender());
		System.out.println("Address : " + getAddress());
		System.out.println("\n\n");
	}
}