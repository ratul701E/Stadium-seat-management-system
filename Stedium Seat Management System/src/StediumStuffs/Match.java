package StediumStuffs;
import Users.Client;

// ratul

public class Match {
	private String description;
	private String id;
	private String matchType;
	private String matchDay;
	private int vipSeats;
	private int normalSeats;
	private double vipCost;
	private double normalCost;
	private boolean isValid;
	private Client clients[];
	
	
	// constructors
	
	public Match() {
		
	}
	
	public Match(String matchType, int vipSeats, int normalSeats) {
		this.isValid = true;
		this.matchType = matchType;
		this.vipSeats = vipSeats;
		this.normalSeats = normalSeats;
		this.matchId();
		this.clients = new Client[200];
	}
	
	public Match(String id, String matchDay, String description, String matchType, int vipSeats, int normalSeats, int vipCost, int normalCost) {
		this(matchType, vipSeats, normalSeats);
		this.matchDay = matchDay;
		this.description = description;
		this.id = id;
		this.vipCost = vipCost;
		this.normalCost = normalCost;
	}
	
	
	// sets
	
	public void setDesciption(String description) {
		this.description = description;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setVipSeats(int vipSeats) {
		this.vipSeats = vipSeats;
	}
	
	public void setNormalSeats(int normalSeats) {
		this.normalSeats = normalSeats;
	}
	
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	
	public void setMatchDay(String matchDay) {
		this.matchDay = matchDay;
	}
	
	public void setVipCost(double cost) {
		vipCost = cost;
	}
	
	public void setNormalCost(double cost) {
		normalCost = cost;
	}
	
	
	
	// gets
	
	public String getDesciption() {
		return description;
	}
	
	public String getId() {
		return id;
	}
	
	public int getVipSeats() {
		return vipSeats;
	}
	
	public int getNormalSeats() {
		return normalSeats;
	}
	
	public boolean getValid() {
		return isValid;
	}
	
	public String getMatchType() {
		return matchType;
	}
	
	public String getMatchDay() {
		return matchDay;
	}
	
	public int getTotalTickets() {
		return vipSeats + normalSeats;
	}
	
	public double getVipCost() {
		return vipCost;
	}
	
	public double getNormalCost() {
		return normalCost;
	}
	
	// add seats
	
	public void addVipSeats(int seats) {
		if(seats < 0) return;
		vipSeats += seats;
	}
	
	public void addNormalSeats(int seats) {
		if(seats < 0) return;
		normalSeats += seats;
	}
	
	public boolean addClient(Client client) {
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]== null ) {
				clients[i]= client; 
				return true;
			}
		}
		return false;
	}
	
	// remove seats
	
	public void removeVipSeats(int seats) {
		if(seats < 0) return;
		vipSeats -= seats;
	}
	
	public void removeNormalSeats(int seats) {
		if(seats < 0) return;
		normalSeats -= seats;
	}
	
	
	public boolean removeClient(Client client) {
		for(int i = 0; i < clients.length; i++) {
			if(clients[i]== client ) {
				clients[i]= null; 
				return true;
			}
		}
		return false;
	}
	
	
	// shows
	
	public void shortDetails() {
		if(isValid) System.out.printf("%-10s   ","valid");
		else System.out.printf("%-10s   ","invalid");
		System.out.printf("%-10s   %-15s   Seats vip (%d) normal (%d)\n", matchType,matchDay,vipSeats,normalSeats);
		System.out.println("---------------------------------------------------------------------------\n");
	}
	
	public void fullDetails() {
		System.out.println("Match type : " + matchType);
		System.out.println("Date : " + matchDay);
		System.out.println("Vip seat available : " + vipSeats);
		System.out.println("Normal seat available : " + normalSeats);
		System.out.println("Costs : Vip : " + vipCost + " tk\tNormal : " + normalCost);
		System.out.println("\nDescription:\n" + description);
	}
	
	// privates
	
	private void matchId() {
		this.id = "";
		for(int i = 0; i < 7 ; i++) {
			int c = (int)  Math.random() * ('Z' - 'A' + 1) + 'A';
			id += (char)c;
		}
	}
	
}
