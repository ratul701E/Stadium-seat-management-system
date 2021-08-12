/*
 * This interface is written by Fardin Ibna Rahman
 * Id : 21-44705-1
 * 
 */

package StediumStuffs;

import java.io.Serializable;



public class Mail implements Serializable{
	
	private boolean isAdmin = false;
	private String sender;
	private String message;
	
	
	public Mail(){}
	
	public Mail(String sender, String message){
		this.sender = sender;
		this.message = message;
	}
	
	public Mail(String sender, String message, boolean isAdmin){
		this(sender,message);
		this.isAdmin = isAdmin;
	}
	
	//sets
	
	public void setSender(String sender){
		this.sender = sender;
	}
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	// gets
	
	public String getSender(){
		return sender;
	}
	public String getMessage(){
		return message;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	
	
	public void showDetails(){
		String space = "                                         ";
		System.err.println(space + "-----------------------------------------------");
		System.out.print(space + "Sender : "+sender);
		
		if(isAdmin) {
			System.out.println("   (Admin)");
		}else {
			System.out.println("   (Client)");
		}
		
		System.out.println(space + "Message : "+message);
		System.err.println(space + "-----------------------------------------------");
		System.err.println("\n");
	}
}