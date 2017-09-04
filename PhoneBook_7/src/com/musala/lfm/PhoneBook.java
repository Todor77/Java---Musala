package com.musala.lfm;

import java.util.Scanner;

public class PhoneBook {

	Scanner scanner = new Scanner(System.in);
	
	private String name;
	private String number;

	private int lenn;
	
	public PhoneBook(String name, String number) {
		
		setName(name);
		setNumber(number);
	}
	
	public PhoneBook() {
		
		this.name = "";
		this.number = "";
	}
	
	
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	
	public void setName(String name) {
		
		if(name != null) {
			this.name = name;
		}
		
	}
	public void setNumberCall(String number) {
		
		this.number = number;
	}
	
	
	public boolean setNumber(String number) {
		
		lenn = number.length();

		boolean check = false;
		if(lenn == 10) {
			String st = number.substring(1, 3);
			
			if(st.equals("87") || st.equals("88") || st.equals("89")) {
				
				char h = number.charAt(3);
				if(h <= '9' && h >= '2') {
					
					String temp = number.replace(number.substring(0,1),"+359");
					this.number = temp;
					
					
					check= true;
				}
			}
		}
		else if(lenn == 11) {
			
			String st = number.substring(4, 6);
			
			if(st.equals("87") || st.equals("88") || st.equals("89")) {
				
				char h = number.charAt(6);
				if(h <= '9' && h >= '2') {
					
					this.number = number;
					check= true;
				}
			}
			
		}
		else if (lenn == 14) {
			
			String st = number.substring(5, 7);
			
			if(st.equals("87") || st.equals("88") || st.equals("89")) {
				
				char h = number.charAt(7);
				if(h <= '9' && h >= '2') {
					
					String temp = number.replace(number.substring(0,2),"+");
					this.number = temp;
					check= true;
				}
			}	
		}else {
			
			this.number ="Gresen !!!";
			check = true;
		}
		return check;
	}
	
	
	public void read() {
		
		String s;
		
		System.out.println("Insert Person Name");
		s = scanner.nextLine();
		setName(s);
		
		do {
			System.out.println("Insert Phone Number");
			s = scanner.nextLine();
			//setNumber(s);
			
		}while(setNumber(s) != true);
	
	}
	
	@Override
	public String toString() {
		
		return name + " " + number+ " ";
	}

	
	
}
