/*
 * This class is written by Asraful Alam Ratul
 * Id : 21-44588-1
 * 
 */

package Database;

import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import Users.Admin;


public class AdminFileHandler {

	public ObjectOutputStream objOut;	// to write object in file
	public ObjectInputStream objIn;		// to read object from file
	private String path;				// file path string
	
	public AdminFileHandler(String path) {
		this.path = path;
	}
	
	public void write(Admin admins[]) {
		try {
			objOut = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			for(int i = 0; i < admins.length; i++) {
				if(admins[i] != null) {
					objOut.writeObject(admins[i]);	//saving object in file
					//System.out.println("Wrote");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				objOut.close();		//closing file
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}
	
	public Admin[] read(){
		try {
			objIn = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
		} catch (IOException e) {
			//e.printStackTrace();
		}
		Admin[] admins = new Admin[200];
		int i = 0;
		try{
			
			do {
				Admin temp = (Admin) objIn.readObject(); 	// read object and casting to appropriate class
				if(temp != null ) {
					admins[i]= temp; 
					i++;
				} else {
					
					return admins;
				}
			}while(true);
		}
		catch (EOFException e) {
			return admins; 
		}
		catch(Exception e){
			
			//e.printStackTrace();
			return null;
		}
		finally{
			try {
				objIn.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}
}


