package com.musala.lfm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main (String [] args) {
		
		ContactList book = new ContactList();
		
		Map<String,String> phonebook = new HashMap<>();
		
		
		try {
			setMap(phonebook);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		book.fillCorrect(phonebook);
		
		book.displayPhone();
		
		book.addRecord();
		
		book.displayPhone();
		
		book.removePair();
		
		book.displayPhone();
		
		book.findPair();
		//display map in sorted way
		//displayMap(phonebook);
	}
	
	 static void setMap(Map<String,String> phonebook) throws IOException {
			
			BufferedReader br = new BufferedReader(new FileReader("phone"));
			
			
			try {
				
				String line = br.readLine();
				
				while(line != null) {
					
					String[] splited = line.split(" ");
					
					String key = splited[0];
					String value = splited[1];
					
					phonebook.put(key, value);
					
					line = br.readLine();
					
				}
				 
			}finally{
				
				br.close();
			}
		}
	 
	 static void displayMap(Map<String,String> phonebook) {
			
			Set<String> keys = phonebook.keySet();
			
			TreeSet<String> sortedKeys = new TreeSet<String> (keys);
			
			
			for(String key : sortedKeys)
				System.out.println(key + " " + phonebook.get(key));
		}
	 
	 
}
