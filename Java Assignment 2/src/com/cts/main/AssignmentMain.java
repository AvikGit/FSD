package com.cts.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cts.bean.Book;
import com.cts.bean.Subject;
import com.cts.dao.AssignmentDAO;
import com.cts.service.AssignmentService;

public class AssignmentMain {

	public static void main(String[] args) {
		
		try { 
			
			 	boolean exit = false;

			    do
			    {
			    	System.out.println("\n\nPlease select a menu option:");
					System.out.println("1. Add a Book");
					System.out.println("2. Delete a Subject");
					System.out.println("3. Delete a Book");
					System.out.println("4. Search for a Book");
					System.out.println("5. Search for a Subject");
					System.out.println("6. Exit");
					Scanner scanner = new Scanner(System.in);
					int number;
					List<Subject> subjects = new ArrayList<Subject>();
					List<Book> books = new ArrayList<Book>();
					number = scanner.nextInt();
			       	AssignmentService as = new AssignmentService();
			    	AssignmentDAO ad = new AssignmentDAO();
			    	/*if(number == 1) {
			    		subjects = as.addSubject(subjects);
			    		System.out.println("Subject Added Successfully.");
					}
			    	else */if(number == 1) {
			    		books = as.addBook(books);
			    		System.out.println("Book Added Successfully.");
					}
			    	else if(number == 4) {
						System.out.print("Enter Book ID: ");
						int id = Integer.valueOf(scanner.next());
						Book b = ad.searchBook(id);
						if(b != null)
							System.out.println("Book Name: " + b.getTitle());
						else
							System.out.println("Book not found");
					}
					else if(number == 5) {
						System.out.print("Enter Subject ID: ");
						int id = Integer.valueOf(scanner.next());
						Subject s = ad.searchSubject(id);
						if(s != null)
							System.out.println("Subject Name: " + s.getSubtitle());
						else 
							System.out.println("Subject not found");
					}
					else if(number == 2) {
						System.out.print("Enter Subject ID: ");
						int id = Integer.valueOf(scanner.next());
						ad.deleteSubject(id);
						System.out.println("Subject deleted successfully");
					}
					else if(number == 3) {
						System.out.print("Enter Book ID: ");
						int id = Integer.valueOf(scanner.next());
						ad.deleteBook(id);
						System.out.println("Book Deleted successfully.");
					}
					else if(number == 6) {
						System.out.print("Exiting application...");
						exit = true;
					}
					else {
						System.out.println("Invalid Choice!!!");
					}				    
			    }while(!exit);
				
		/*	
			
			
	
			Scanner scanner = new Scanner(System.in);
			int number;
			List<Subject> subjects = new ArrayList<Subject>();
			List<Book> books = new ArrayList<Book>();
			do {
			    System.out.print("Please enter the option you want to select: ");
			    while (!scanner.hasNextInt()) {
			        System.out.println("Please select an option between 1 to 7!");
			        System.out.print("Please enter the option you want to select: ");
			        scanner.next(); 
			    }
			    
			    }
			} while (number > 7 || number < 1 );*/
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
