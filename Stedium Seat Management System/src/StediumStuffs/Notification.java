package StediumStuffs;
/*
 * This class is written by Rianul Amin Rian
 * ID : 21-44589-1
 * 
 */

import java.io.Serializable;

public class Notification implements Serializable{
	
	private String sender;
	private String message;
	private boolean priority;
	
	public Notification(){}
	public Notification(String sender, String message, boolean priority){
		this.sender = sender;
		this.message = message;
		this.priority = priority;
	}
	
	public void setSender(String sender){
		this.sender = sender;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public void setPriority(boolean priority){
		this.priority = priority;
	}
	
	public String getSender(){
		return sender;
	}
	public String getMessage(){
		return message;
	}
	public boolean getPriority(){
		return priority;
	}
	
	public void showDetails(){
		System.out.println("Sender : "+sender);
		System.out.println("Message : "+message);
		System.out.print("Priority : ");
		if(priority){
			System.out.println("high");
		}
		else{
			System.out.println("low");
		}
	}
}