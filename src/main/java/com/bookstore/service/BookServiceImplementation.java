package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.BookRepository;
import com.bookstore.model.Book;


@Service
public class BookServiceImplementation implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
 

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

 
    
    
    //searchBooks("author", String author)
    //searchBooks("price", float price)
    
    
    //todo - overload and w/e
    public List<Book> searchBooks(String searchCategory, String searchTerm ) {
        // Implement search logic based on the keyword
    	
    	//bookRepository.findAll(searchCategory, searchTerm );
        // For example: return bookRepository.findByTitleContainingOrAuthorContaining(keyword, keyword);
    	switch(searchCategory) {
    	case "author":
    		return bookRepository.findByAuthor(searchTerm);
    	case "title":
    		return bookRepository.findByTitle(searchTerm);
    	case "price":
    		return bookRepository.findByPrice(Float.parseFloat(searchTerm));
    	default:
    		return null;
    	}
    }

 
    
    public Book addBook(Book book) {
        // Implement logic to add a new book
        return bookRepository.save(book);
    }

 

    public Book updateBook(int id, Book updatedBook) {
        // Implement logic to update an existing book by ID
        if (bookRepository.existsById(id)) {
            updatedBook.setId(id);
            return bookRepository.save(updatedBook);
        }
        return null; // Book not found
    }

 

    public List<Book> deleteBook(int id) {
        // Implement logic to delete a book by ID
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        return bookRepository.findAll();
    }
}

