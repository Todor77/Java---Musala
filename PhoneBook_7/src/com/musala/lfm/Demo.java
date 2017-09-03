package com.musala.lfm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Demo {

	public static void main(String [] args) {
		
		Set<String> list = new TreeSet<String>();

		
		try {
			setTree(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		Contact contact = new Contact();
		
		contact.fillCorrect(list);
		contact.displayContacts();
		
		contact.addRecord();
		
		contact.displayContacts();
		
		PhoneBook p = new PhoneBook("miki","+3568882932");
		
		contact.removePair(p);
		
		contact.displayContacts();
		
		System.out.println(contact.findPair());
		
	}
	
	static void setTree(Set<String> phonebook) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("phone"));

		try {
			
			String line = br.readLine();
			
			while(line != null) {
				
				phonebook.add(line);
				
				line = br.readLine();	
			}
			 
		}finally{
			
			br.close();
		}
	}
}
