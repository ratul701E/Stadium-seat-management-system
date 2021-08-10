
package Database;

import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import Users.Client;


public class ClientFileHandler {
	public ObjectOutputStream objOut;		// to write object in file
	public ObjectInputStream objIn;			// to read object in file
	private String path;					// file path string
	
	public ClientFileHandler(String path) {
		this.path = path;
	}
	
	public void write(Client clients[]) {
		try {
			objOut = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			for(int i = 0; i < clients.length; i++) {
				if(clients[i] != null) {
					objOut.writeObject(clients[i]);		//saving object in file
					//System.out.println("Wrote");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				objOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Client[] read(){
		try {
			objIn = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Client[] clients = new Client[200];
		int i = 0;
		try{
			
			do {
				Client temp = (Client) objIn.readObject();		// read object and casting to appropriate class
				if(temp != null ) {
					clients[i]= temp; 
					i++;
				} else {
					
					return clients;
				}
			}while(true);
		}
		catch (EOFException e) {
			//System.out.println("EOF exception happened");
			return clients; 
		}
		catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				objIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


