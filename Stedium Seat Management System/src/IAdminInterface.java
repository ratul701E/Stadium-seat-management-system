
public interface IAdminInterface {
	
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
