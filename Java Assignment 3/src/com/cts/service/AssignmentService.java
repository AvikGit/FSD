package com.cts.service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cts.bean.Book;
import com.cts.bean.Subject;
import com.cts.dao.AssignmentDAO;

public class AssignmentService {
	
	public List<Subject> addSubject(List<Subject> subjects) {
		LocalDate ld = LocalDate.parse("2018-09-14");

		Book book1 = new Book(100, "Book1", 1000, 1, ld);
		Book book2 = new Book(101, "Book2", 250, 2, ld);
		Set<Book> books = new HashSet<>();
		books.add(book1); 
		books.add(book2);
		
		Subject subject = new Subject(1, "Science", 5, books);

		subjects.add(subject);
		writingSubjectFileBinary(subjects);
		return subjects;
		
	}
	
	public List<Book> addBook(List<Book> books) {
		LocalDate ld = LocalDate.parse("2018-09-14");

		Book book3 = new Book(100, "Book3", 1000, 1, ld);
		AssignmentDAO ad = new AssignmentDAO();
		ad.insertBook(book3);
		books.add(book3);
		//writingBookFileBinary(books);
		return books;
		
	}
	

    public void writingSubjectFileBinary(List<Subject> listofSubjects){ 
	    try{ 
	         FileOutputStream fo=new FileOutputStream(new File("D:\\FSD\\CoreJava\\Assignment1\\Subject.ser")); 
	         ObjectOutputStream oos=new ObjectOutputStream (fo); 
	         for(Subject s: listofSubjects) {
	        	 oos.writeObject(s); 
	         }
	         oos.flush();
	         oos.close();  
		} catch(IOException ie){
			System.out.println("IO problem!");
			ie.printStackTrace();
		}
    }		
    
    public void writingBookFileBinary(List<Book> listofBooks){ 
	    try{ 
	         FileOutputStream fo=new FileOutputStream(new File("D:\\FSD\\CoreJava\\Assignment1\\Book.ser")); 
	         ObjectOutputStream oos=new ObjectOutputStream (fo); 
	         for(Book b: listofBooks) {
	        	 oos.writeObject(b); 
	         }
	         oos.flush();
	         oos.close();  
		} catch(IOException ie){
			System.out.println("IO problem!");
			ie.printStackTrace();
		}
    }	
    

    public Subject readingSubjectFileBinary(int subjectId){ 
    	ObjectInputStream ois = null;
    	try{ 
	        ois = new ObjectInputStream(new FileInputStream("D:\\FSD\\CoreJava\\Assignment1\\Subject.ser")); 
	        Subject s = null;
	        while(true){
		    	s = (Subject) ois.readObject();
		    	if(s != null) {
		    		if(s.getSubjectId() == subjectId) {
		    			return s;
		    		}
		    	}
		    } 
	    }  catch(IOException | ClassNotFoundException ie) {
	    	System.out.println("IO problem!");
	    	ie.printStackTrace();
	    } finally {
	    	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return null; 
    } 
    
    
    public Book readingBookFileBinary(int bookId){ 
    	ObjectInputStream ois = null;
    	try{ 
	        ois = new ObjectInputStream(new FileInputStream("D:\\FSD\\CoreJava\\Assignment1\\Book.ser")); 
	        Book b = null;
	        while(true){
		    	b = (Book) ois.readObject();
		    	if(b != null) {
		    		if(b.getBookId() == bookId) {
		    			return b;
		    		}
		    	}
		    } 
	    }  catch(IOException | ClassNotFoundException ie) {
	    	System.out.println("IO problem!");
	    	ie.printStackTrace();
	    } finally {
	    	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return null; 
    } 
    
    public boolean deletingSubjectFileBinary(int subjectId){ 
    	List<Subject> subjects = new ArrayList<Subject>();
    	ObjectInputStream ois = null;
    	FileInputStream fis = null;
    	try{ 
    		fis = new FileInputStream("D:\\FSD\\CoreJava\\Assignment1\\Subject.ser");
    		ois = new ObjectInputStream(fis); 
	        
	        Subject s = null;
	        while(true){
		    	s = (Subject) ois.readObject();
		    	System.out.println(s.getSubtitle());
		    	if(s != null) {
		    		if(s.getSubjectId() != subjectId) {
		    			subjects.add(s);
		    		} 
		    	}
		    } 
	        
	    }  catch(IOException ie) {
	    	if(fis != null) {
	    		try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(ois != null) {
	    		try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(subjects.size() > 0) {
	    		writingSubjectFileBinary(subjects);
	    	} else {
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Subject.ser").delete();
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Subject.ser");
	    	}
	    } catch (ClassNotFoundException ee) {
	    	if(fis != null) {
	    		try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(ois != null) {
	    		try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(subjects.size() > 0) {
	    		writingSubjectFileBinary(subjects);
	    	} else {
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Subject.ser").delete();
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Subject.ser");
	    	}
	    }
	    return true; 
    } 
    
    
    public boolean deletingBookFileBinary(int bookId){ 
    	List<Book> books = new ArrayList<Book>();
    	ObjectInputStream ois =  null;
    	FileInputStream fis = null;
    	try{ 
    		fis = new FileInputStream("D:\\FSD\\CoreJava\\Assignment1\\Book.ser");
    		ois = new ObjectInputStream(fis); 
	        
	        Book b = null;
	        while(true){
		    	b = (Book) ois.readObject();
		    	if(b != null) {
		    		if(b.getBookId() != bookId) {
		    			books.add(b);
		    		} 
		    	}
		    } 
	    }  catch(IOException ie) {
	    	if(fis != null) {
	    		try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(ois != null) {
	    		try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(books.size() > 0) {
	    		writingBookFileBinary(books);
	    	} else {
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Book.ser").delete();
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Book.ser");
	    	}
	    } catch (ClassNotFoundException ee) {
	    	if(fis != null) {
	    		try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(ois != null) {
	    		try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(books.size() > 0) {
	    		writingBookFileBinary(books);
	    	} else {
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Book.ser").delete();
	    		new File("D:\\FSD\\CoreJava\\Assignment1\\Book.ser");
	    	}
	    }
	    return true; 
    } 

}
