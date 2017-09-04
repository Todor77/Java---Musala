package com.musala.lfm;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Contact {

	Scanner scanner = new Scanner(System.in);
	private Set<PhoneBook> list; 
	
	PhoneBook phone = new PhoneBook();
	
	public Contact() {
		
		this.list = new TreeSet<>(new EmpComp());
	}
	
	public void fillCorrect(Set<String> lists) {
		
		Iterator<String> itr = lists.iterator();
		
		while(itr.hasNext()) {
			
			String [] splited = itr.next().split(" ");
			String name = splited[0];
			String number = splited[1];
			


			
			list.add(new PhoneBook(name,number));
			
		}
		
	}
	
	public void addRecord() {
		PhoneBook phone = new PhoneBook();
		System.out.println("Enter name: ");
		String name = scanner.next();
		
		phone.setName(name);
		
		
		System.out.println("Enter number: ");
		String number = scanner.next();
		
		phone.setNumber(number);
		
		
		list.add(phone);
		
	}
	
	public void removePair(PhoneBook p) {
		System.out.println(p);
		
		//tuka mi e napraeno na obratno oti nemoze da go nameri dali 
		//go ima u listata taka che od fajla koga cita ima edna dolzina 
		//a od tuka kogato mu go podam s konstruktor ima druga i kazva che 
		//ne postoi tozi zapis a taka go maha
		if(!list.contains(p)) {
			list.remove(p);
		}
		
	}
	
	public PhoneBook findPair() {
		System.out.println();
		System.out.println("Enter name to Find");
		
		String name = scanner.next();
		String number = null;
		
		 Iterator<PhoneBook> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			PhoneBook phone = iterator.next();
			
			if(phone.getName().equals(name)) {
				
				return phone;
			}
		}
		return null;
	}
	
	
	
	public void displayContacts() {
		
		Iterator<PhoneBook> itr = list.iterator();
		
		while(itr.hasNext()) {
			
			
			System.out.print(itr.next());
			System.out.println();
			
		}
		
	}
	
	public void addCalls() {
		System.out.println();
		System.out.println("Enter name add calls");
		
		String name = scanner.next();
		String n;
		System.out.println("Enter how much calls");
		n = scanner.next();
		
		 Iterator<PhoneBook> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			PhoneBook phone = iterator.next();
			
			if(phone.getName().equals(name)) {
				
				phone.setNumberCall(phone.getNumber()+ " "+ n);
			}
		}
		
	}
	
}

class EmpComp implements Comparator<PhoneBook>{
	
	 @Override
	    public int compare(PhoneBook e1, PhoneBook e2) {
	        if(e1.getName() == e2.getName()){
	            return 0;
	        }
			return 1;
	    }
	
}
