/*
 * Asraful Alam Ratul writes this class
 * Id : 21-44588-1
 * 
 */
package Database;

import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import StediumStuffs.Match;


public class MatchFileHandler {
	public ObjectOutputStream objOut;		// to write object in file
	public ObjectInputStream objIn;			// to read object from file
	private String path;					// file path string
	
	public MatchFileHandler(String path) {
		this.path = path;
	}
	
	public void write(Match matches[]) {
		try {
			objOut = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
		} catch (IOException e) {
			//e.printStackTrace();
		}
		try {
			for(int i = 0; i < matches.length; i++) {
				if(matches[i] != null) {
					objOut.writeObject(matches[i]);		//saving object in file
					//System.out.println("Wrote");
				}
			}
		} catch (IOException e) {
			//e.printStackTrace();
		}
		finally {
			try {
				objOut.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}
	
	public Match[] read(){
		try {
			objIn = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
		} catch (IOException e) {
			//e.printStackTrace();
		}
		Match[] matches = new Match[200];
		int i = 0;
		try{
			
			do {
				Match temp = (Match) objIn.readObject();		// read object and casting to appropriate class
				if(temp != null ) {
					matches[i]= temp; 
					i++;
				} else {
					
					return matches;
				}
			}while(true);
		}
		catch (EOFException e) {
			return matches; 
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

