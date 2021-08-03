package Interfaces;
import StediumStuffs.Mail;
import StediumStuffs.Match;
import StediumStuffs.Notification;
import StediumStuffs.Ticket;

public interface IClientInterface {
	
	public static final int size = 200;
	
	public Ticket[] getCancelledTickets();
	public Ticket[] getPurchasedTickets();
	
	public boolean addMail(Mail mail);
	public boolean addNotification(Notification notification);
	public boolean addTicket(Ticket ticket);
	public boolean addToCancelledTicket(Ticket ticket);
	public boolean addToUpcomingMatches(Match match);
	public boolean addToPurchaseHistory(Ticket ticket);
	
	
	public boolean removeMail(Mail mail);
	public boolean removeNotification(Notification notification);
	public boolean removeTicket(Ticket ticket);
	public boolean removeFormCancelledTicket(Ticket ticket);
	public boolean removeFormUpcomingMatches(Match match);
	public boolean removeFormPurchaseHistory(Ticket ticket);
	
	public Ticket searchTicket(String id);
	
	public int countTickets();
	public int countCancelldTickets();
	public int countPurchedTickets();
	public int countAllMails();
	
	public void shortProfile();
	public void showAllTickets();
}
