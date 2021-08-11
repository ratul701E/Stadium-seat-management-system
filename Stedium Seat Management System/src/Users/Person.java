/*
 * This class is written by Rianul Amin Rian
 * Id : 21-44589-1
 * 
 * 
 */

package Users;
import java.io.Serializable;


public class Person implements Serializable{
	
	private String name;
	private int age;
	private String gender;
	private String number;
	private String address;
	
	public Person(){}
	
	public Person(String name, int age, String gender, String number, String address){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.number = number;
		this.address = address;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void showDetails(){
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Gender : "+gender);
		System.out.println("Number : "+number);
		System.out.println("Address : "+address);
	}
	
}
