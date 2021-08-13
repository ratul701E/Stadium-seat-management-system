/*
 * Rianul Amin Rian writes this interface
 * Id : 21-44589-1
 * 
 */

package Interfaces;

import StediumStuffs.*;

public interface IAdminInterface {
	
	public static final int size = 200;
	
	
	public boolean addFeedbacks(Feedback feedback);
	
	public boolean addNotification(Notification notification);
	public void addMatch();
	
	public boolean removeFeedbacks(Feedback feedback);
	public boolean removeMail(Mail mail) ;
	public boolean removeNotification(Notification notification);
	
	public void manageClients();
	public void manageMatches();
	
	public void showAllMails();
	
	public static boolean addMail(Mail mail) {
		return false;
	}
}
