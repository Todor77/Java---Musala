package com.musala.lfm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContactList {

	Scanner scanner = new Scanner(System.in);
	private Map<String,String> contacts= new HashMap<>();
	
	PhoneBook phone = new PhoneBook();
	
	
	
	public void fillCorrect(Map<String,String> contact){
		
		
		
		for(String k : contact.keySet()) {
			
			String name = k;
			String num = contact.get(k);
			
			phone.setName(name);
			phone.setNumber(num);

			contacts.put(phone.getName(), phone.getNumber());
			
		}
		
	}
	
	public void displayPhone() {
		
		Set<String> keys = contacts.keySet();
		
		TreeSet<String> sortedKeys = new TreeSet<String> (keys);
		
		
		for(String key : sortedKeys)
			System.out.println(key + " " + contacts.get(key));
	}
	
	public void addRecord() {
		
		System.out.println("Enter name: ");
		String name = scanner.next();
		
		phone.setName(name);
		
		
		System.out.println("Enter number: ");
		String number = scanner.next();
		
		phone.setNumber(number);
		
		
		contacts.put(phone.getName(),phone.getNumber());
		
	}
	
	public void removePair() {
		
		System.out.println("Enter name to delete");
		String name = scanner.next();
		
		
		contacts.remove(name);
		
		
	}
	
	public void findPair() {
		
		System.out.println("Enter name to Find");
		
		String name = scanner.next();
		String number = null;
		
		if(contacts.containsKey(name)) {
			number = contacts.get(name);
			
			System.out.println(contacts.get(name));
			
		}else {
			System.out.println("Njama takov par");
		}
	}
	
	
	
	
	
	
	
}
