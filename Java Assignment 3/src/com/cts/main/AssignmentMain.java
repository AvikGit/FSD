package com.cts.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
					System.out.println("6. Sort Book By Title");
					System.out.println("7. Sort Subject By Subject Title");
					System.out.println("8. Sort Books by publish Date");
					System.out.println("9. Exit");
					Scanner scanner = new Scanner(System.in);
					int number;
					
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
					else if(number == 7) {
						Book book1 = new Book(100, "Book1", 1000, 1, LocalDate.parse("2018-09-26"));
						Set<Book> bookList = new HashSet<>();
						bookList.add(book1); 
						List<Subject> subjects = new ArrayList<Subject>();
						Subject subject1 = new Subject(1, "Subject4", 5, bookList);
						Subject subject2 = new Subject(2, "Subject1", 5, bookList);
						Subject subject3 = new Subject(3, "Subject5", 5, bookList);
						Subject subject4 = new Subject(4, "Subject2", 5, bookList);
						Subject subject5 = new Subject(5, "Subject3", 5, bookList);
						subjects.add(subject1);
						subjects.add(subject2);
						subjects.add(subject3);
						subjects.add(subject4);
						subjects.add(subject5);
						System.out.println("Before sorting..");
						subjects.forEach(e -> System.out.println("Subject Id:"+ e.getSubjectId()+", Subtitle: "+e.getSubtitle()+", Duration:"+e.getDurationInHours()));
						List<Subject> slist = subjects.stream().sorted().collect(Collectors.toList());
						System.out.println("After sorting..");
						slist.forEach(e -> System.out.println("Subject Id:"+ e.getSubjectId()+", Subtitle: "+e.getSubtitle()+", Duration:"+e.getDurationInHours()));
					}
					else if(number == 6) {
						Book book1 = new Book(100, "Book1", 1000, 1, LocalDate.parse("2018-09-26"));
						Book book2 = new Book(101, "Book4", 1000, 1, LocalDate.parse("2018-09-10"));
						Book book3 = new Book(102, "Book2", 1000, 1, LocalDate.parse("2018-08-15"));
						Book book4 = new Book(103, "Book5", 1000, 1, LocalDate.parse("2017-09-23"));
						Book book5 = new Book(104, "Book3", 1000, 1, LocalDate.parse("2018-10-22"));
						List<Book> bookList = new ArrayList<Book>();
						bookList.add(book1); 
						bookList.add(book2); 
						bookList.add(book3); 
						bookList.add(book4); 
						bookList.add(book5); 
						System.out.println("Before sorting with Book Title..");
						bookList.forEach(e -> System.out.println("Book Id:"+ e.getBookId()+", Title: "+e.getTitle()+", Volume:"+e.getVolume()+", Publish Date:"+e.getPublishDate()));
						List<Book> slist = bookList.stream().sorted().collect(Collectors.toList());
						System.out.println("After sorting with Book Title..");
						slist.forEach(e -> System.out.println("Book Id:"+ e.getBookId()+", Title: "+e.getTitle()+", Volume:"+e.getVolume()+", Publish Date:"+e.getPublishDate()));
					}
					else if(number == 8) {
						Book book1 = new Book(100, "Book1", 1000, 1, LocalDate.parse("2018-09-26"));
						Book book2 = new Book(101, "Book4", 1000, 1, LocalDate.parse("2018-09-10"));
						Book book3 = new Book(102, "Book2", 1000, 1, LocalDate.parse("2018-08-15"));
						Book book4 = new Book(103, "Book5", 1000, 1, LocalDate.parse("2017-09-23"));
						Book book5 = new Book(104, "Book3", 1000, 1, LocalDate.parse("2018-10-22"));
						List<Book> bookList = new ArrayList<Book>();
						bookList.add(book1); 
						bookList.add(book2); 
						bookList.add(book3); 
						bookList.add(book4); 
						bookList.add(book5); 
						System.out.println("Before sorting with Book publish date..");
						bookList.forEach(e -> System.out.println("Book Id:"+ e.getBookId()+", Title: "+e.getTitle()+", Volume:"+e.getVolume()+", Publish Date:"+e.getPublishDate()));
						List<Book> slist = bookList.stream().sorted(Comparator.comparing(Book::getPublishDate)).collect(Collectors.toList());
						System.out.println("After sorting with Book publish date..");
						slist.forEach(e -> System.out.println("Book Id:"+ e.getBookId()+", Title: "+e.getTitle()+", Volume:"+e.getVolume()+", Publish Date:"+e.getPublishDate()));
					}
					else if(number == 9) {
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
