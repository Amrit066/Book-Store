package com.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/*
 * Entity Class for the Book table, which will connect to the database
 * 
 */


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String title;
	private String author;
	private String description;
	private float price;
	private int count;
	
	public Book() {
		
	}
	//Parameterized Constructor
	public Book(int id, String title, String author, String description, float price, int count) {
		super();
		Id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.count = count;
	}
	
	//Getters and Setters
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", count=" + count + "]";
	}
	
}

