package com.scenario.book.service;

import java.util.List;

import com.scenario.book.model.Book;
;
public interface BookService {
	
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public List<Book> searchBooks(String searchCategory, String searchTerm);//to do - implement
	public Book addBook(Book book);
	public Book updateBook(int id, Book updatedBook);
	public List<Book> deleteBook(int id);

}
	