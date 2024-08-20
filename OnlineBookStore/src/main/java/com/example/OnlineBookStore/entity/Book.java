package com.example.OnlineBookStore.entity;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String author;
	private String ISBN;
	private double price;

	

	public Book() {
	
	}
	
	public Book(int id, String title, String author, String iSBN, double price) {
	
		this.id = id;
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.price = price;
	
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", price=" + price
				+ "]";
	}


	

	
	
}
