package com.cts.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable, Comparable<Book>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long bookId;
	private String title;
	private double price;
	private int volume; 
	private LocalDate publishDate;
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}	

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume + ", publishDate="
				+ publishDate + "]";
	}
	public Book(long bookId, String title, double price, int volume,
			LocalDate publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Book o) {		
		return title.compareTo(o.getTitle());	
	}
	
	
}
