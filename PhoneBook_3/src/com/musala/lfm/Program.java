package com.musala.lfm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.xml.stream.util.EventReaderDelegate;

public class Program {

	public static void main(String [] args) throws IOException  {
		
		Scanner scanner = new Scanner(System.in);
		
		PhoneBook book = new PhoneBook();
		
		String emptySpace = " ";
		String fileName;
		
		int choice;
		
		do
		{
			System.out.println("1. New Phone Book (Create a file) ");
			System.out.println("2. Adding new Phone Pair (Add to file)");
			System.out.println("3. Remove a Pair for a given Name (Remove from file) ");
			System.out.println("4. Find a Pair for a given Name (Find Name and print row)");
			System.out.println("5. Print all Phone Pairs ordered by Name(Print whole file) ");
			System.out.println("6. Count outgoing calls (later) ");
			System.out.println("0. Exit");
			
			System.out.println("Your choice : ");
			
			choice = scanner.nextInt();
			
			switch(choice) {
			
					case 1:
		            {
		            	//System.out.println("Insert full path with file name");
		            	//fileName = scanner.nextLine();
		            	createFile();
		                break;
		            }
		
		        case 2:
		            {
		            	book.read();
		            	String inFile = book.getName() + emptySpace + book.getNumber();
		            	insertInFile(inFile);
		                break;
		            }
		
		        case 3:
		            {
		            	String s;
		            	System.out.println("Enter Name to delete :");
		            	s = scanner.next();
		               
		            	removePair(s);
		              
		               
		                break;
		            }
		
		        case 4:
		            {
		            	System.out.println("Enter Person Name to give his Details!!");
		            	String findName = scanner.next();
		            	//String findName = "misko";
		            	readFromFileAndFind(findName);
		                break;
		            }
		        case 5:
		            {
		            	
		            	readFromFile();
		                break;
		
		            }
		        case 6:
		            {
		                
		                break;
		            }
		        case 0:
	            {
	                break;
	            }
	            
		        default: System.out.println("Invalid Choice ! Please try again.");
		        
			}
			
			
		}while(choice != 0);

		
		
	}

	
	static void createFile() throws IOException {
		Path path = Paths.get("C:\\Users\\toso\\Desktop\\New folder\\WriteInFile\\test22.txt");
		
		Files.createDirectories(path.getParent());
		
		try {
			Files.createFile(path);
			System.out.println("Successfuly created new file");
			
		}catch(FileAlreadyExistsException e){
			
			System.out.println("Alredy exist " + e.getMessage());
		}
	}
	static void createFile(String str) throws IOException {
		Path path = Paths.get(str);
		
		Files.createDirectories(path.getParent());
		
		try {
			Files.createFile(path);
			System.out.println("Successfuly created new file");
			
		}catch(FileAlreadyExistsException e){
			
			System.out.println("Alredy exist " + e.getMessage());
		}
	}
	
	static void insertInFile() {
		
		try {
			FileWriter writer = new FileWriter("text2.txt",true);
			
			PrintWriter printer = new PrintWriter(writer);
			printer.append("Tosko e programist 2");
			printer.append("\n");
			printer.close();
			System.out.println("Successfuly writed in the file");
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	static void insertInFile(String str) {
		
		try {
			FileWriter writer = new FileWriter("text2.txt",true);
			
			PrintWriter printer = new PrintWriter(writer);
			printer.append(str);
			printer.append("\n");
			printer.close();
			System.out.println("Successfuly writed in the file");
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	static void readFromFile() throws IOException {
		
		readFromSortFile();
		
		BufferedReader br = new BufferedReader(new FileReader("text212.txt"));
		String everything;
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				
			}
			 everything = sb.toString();
		}finally{
			
			br.close();
		}
		
		System.out.println(everything);
	}
	
	
	static void readFromSortFile() throws IOException {
		
		String inputFile = "text2.txt";
		String outputFile = "text212.txt";
		
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String inputLine;
		
		ArrayList<String> lineList = new ArrayList<String>();
		
		while((inputLine = bufferedReader.readLine()) != null) {
			
			lineList.add(inputLine);
		}
		fileReader.close();
		
		Collections.sort(lineList);
		
		FileWriter fileWriter = new FileWriter(outputFile);
		PrintWriter out = new PrintWriter(fileWriter);
		
		for(String outputLine : lineList) {
			out.println(outputLine);
		}
		
		out.flush();
		out.close();
		fileWriter.close();
	}
	
	
	static void readFromFileAndFind(String name) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("text2.txt"));
		String everything;
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				
				String[] splited = line.split(" ");
				
				String namee = splited[0];
				String numberr = splited[1];
				
				if(namee.equals(name)) {
					System.out.println("The name was found!!");
					String result = namee + " " + numberr;
					System.out.println(result);
					break;
				}
				
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				
			}
			 everything = sb.toString();
		}finally{
			
			br.close();
		}	
	}
	
	
	static void removePair(String name) throws IOException {
		
		File inputFile = new File("C:\\Users\\toso\\Desktop\\New folder\\PhoneBook_3\\text2.txt");
		File tempFile = new File("C:\\Users\\toso\\Desktop\\New folder\\PhoneBook_3\\text555.txt");
		
		BufferedReader  reader = new BufferedReader (new FileReader(inputFile));
		PrintWriter  writer = new PrintWriter (new FileWriter(tempFile));
		
		String currentLine;
		
		while((currentLine = reader.readLine()) != null) {
			
			String [] spliter = currentLine.split(" ");
			String namee = spliter[0];
			
			if(!namee.equals(name)) {
				
				writer.write(currentLine);
				writer.write("\n");
			}
			
		}
		reader.close();
		writer.close();
		
		inputFile.delete();
		
		if(!tempFile.renameTo(inputFile))
			System.out.println("Could not rename file");
		else
			System.out.println("Successfuly deleted pair");
	
	}
	
	
	
	
}
