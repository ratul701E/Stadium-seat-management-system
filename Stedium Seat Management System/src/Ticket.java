// ratul
public class Ticket {
	private String ID;
	private int quantities;
	private double price;
	private String type;
	
	
	
	public Ticket() {}
	public Ticket(String ID, int quantities, double price, int type) {
		this.ID = ID;
		this.quantities = quantities;
		this.price = price;
		if(type == 1) {
			this.type = "VIP";
		}else {
			this.type = "NORMAL";
		}
	}
	
	
	//sets
	
	public void setId(String ID){
		this.ID = ID;
	}
	
	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	//gets
	
	public String getId() {
		return ID;
	}
	
	public int getQuantities() {
		return quantities;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	// shows
	
	public void showTicket() {
		System.out.println("ID : " + ID + "\n"
				+ "Type : " + type);
	}
	
}
