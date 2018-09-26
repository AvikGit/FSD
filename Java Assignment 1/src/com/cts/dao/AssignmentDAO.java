package com.cts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.bean.Book;
import com.cts.bean.Subject;
import com.mysql.jdbc.Driver;

public class AssignmentDAO implements DriverAction {
	
	public void insertBook(Book book) {
		
		Driver driver = null;
		Connection con = null;
		try {
			 driver = new Driver();
			 DriverAction da = new AssignmentDAO();
			 DriverManager.registerDriver(driver, da);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","pass@word1");
			 PreparedStatement ps = con.prepareStatement("INSERT INTO SAKILA.BOOK (BOOKID, TITLE, PRICE, VOLUME, PUBLISHDATE)  VALUES(?, ?, ?, ?, ?)");
			 ps.setLong(1, book.getBookId());
			 ps.setString(2, book.getTitle());
			 ps.setDouble(3, book.getPrice());
			 ps.setInt(4, book.getVolume());
			 ps.setDate(5, Date.valueOf(book.getPublishDate()));
			 
			 ps.executeUpdate();
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	public Book searchBook(int bookId) {
		
		Driver driver = null;
		Connection con = null;
		ResultSet rs = null;
		Book b = null;
		try {
			 driver = new Driver();
			 DriverAction da = new AssignmentDAO();
			 DriverManager.registerDriver(driver, da);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","pass@word1");
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM SAKILA.BOOK WHERE BOOKID = ?");
			 ps.setLong(1, bookId);
			 
			 rs = ps.executeQuery();
			
			 if(rs.next()) {
				 
				 b = new Book();
				 b.setBookId(rs.getLong(1));
				 b.setTitle(rs.getString(2));
				 b.setPrice(rs.getDouble(3));
				 b.setVolume(rs.getInt(4));
				 b.setPublishDate(rs.getDate(5).toLocalDate());
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return b;
		
		
	}
	
	public Subject searchSubject(int subjectId) {
		
		Driver driver = null;
		Connection con = null;
		ResultSet rs = null;
		Subject s = null;
		try {
			 driver = new Driver();
			 DriverAction da = new AssignmentDAO();
			 DriverManager.registerDriver(driver, da);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","pass@word1");
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM SAKILA.SUBJECT WHERE SUBJECTID = ?");
			 ps.setLong(1, subjectId);
			 
			 rs = ps.executeQuery();
			
			 if(rs.next()) {
				 
				 s = new Subject();
				 s.setSubjectId(rs.getLong(1));
				 s.setSubtitle(rs.getString(2));
				 s.setDurationInHours(rs.getInt(3));
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return s;
		
	}
	
	public void deleteBook(int bookId) {
		
		Driver driver = null;
		Connection con = null;

		try {
			 driver = new Driver();
			 DriverAction da = new AssignmentDAO();
			 DriverManager.registerDriver(driver, da);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","pass@word1");
			 PreparedStatement ps = con.prepareStatement("DELETE FROM SAKILA.BOOK WHERE BOOKID = ?");
			 ps.setLong(1, bookId);
			 
			 ps.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	public void deleteSubject(int subjectId) {
		
		Driver driver = null;
		Connection con = null;
		try {
			 driver = new Driver();
			 DriverAction da = new AssignmentDAO();
			 DriverManager.registerDriver(driver, da);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","pass@word1");
			 PreparedStatement ps = con.prepareStatement("DELETE FROM SAKILA.SUBJECT WHERE SUBJECTID = ?");
			 ps.setLong(1, subjectId);
			 
			 ps.executeUpdate();
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void deregister() {
		System.out.println("Driver Deregistered");
		
	}

}
