package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	String bookName;
	@Column
	double price;
	@Column
	String writer;
	@Column
	int bookNumber;
	
	public Book() {}
	
	public Book(Book book) {
		this.bookName = book.getBookName();
		this.price = book.getPrice();
		this.writer = book.getWriter();
		this.bookNumber = book.getBookNumber();
	}

	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public int getBookNumber() {
		return bookNumber;
	}
	
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	

}
