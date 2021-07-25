

public class Mail{
	
	private String sender;
	private String message;
	
	public Mail(){}
	public Mail(String sender, String message){
		this.sender = sender;
		this.message = message;
	}
	
	public void setSender(String sender){
		this.sender = sender;
	}
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getSender(){
		return sender;
	}
	public String getMessage(){
		return message;
	}
	
	public void showDetails(){
		System.out.println("Sender : "+sender);
		System.out.println("Message : "+message);
	}
}