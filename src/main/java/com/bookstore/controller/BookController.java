package com.bookstore.controller;

// Packages

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;



// Controller Implementation

//@CrossOrigin(origins = "http://localhost:8093")
@RestController
@RequestMapping("/bookinfo")
public class BookController {
	
	//Connecting to book service interface
	@Autowired
	Book bookservice;
	
	
	// Implementation to get info related to all books
	@GetMapping("/getAllBook")
	public List<Book> getAllBook(){
		
		System.out.println("Retreiving All Book Info.....");
		List<Book> booklist = bookservice.getAllBooks();
		return booklist.isEmpty()?Collections.emptyList():booklist;
	}
	
	// Implementation to get info related to specific books
		// Based on id
		@PutMapping("/getBookById/{id}")
		public Book getBookById(@PathVariable("id") int id) {
			return bookservice.getBookById(id);
		}
		// Based on title
		@GetMapping("/getBookByTitle/{title}")
		public List<Book> getBookByTitle(@PathVariable("title") String title){
			
			System.out.println("Retreiving Book Info with title -"+title);
			List<Book> booklist = bookservice.searchBooks("title",title);
			return booklist.isEmpty()?Collections.emptyList():booklist;
		}
		// Based on author
		@GetMapping("/getBookByAuthor/{author}")
		public List<Book> getBookByAuthor(@PathVariable("author") String author){
			
			System.out.println("Retreiving Book Info with autor -"+author);
			List<Book> booklist = bookservice.searchBooks("author",author);
			return booklist.isEmpty()?Collections.emptyList():booklist;
		}
		// Based on author
		@GetMapping("/getBookByPrice/{price}")
		public List<Book> getBookByPrice(@PathVariable("price") String price){
					
			System.out.println("Retreiving Book Info with price -"+price);
			List<Book> booklist = bookservice.searchBooks("price",price);
			return booklist.isEmpty()?Collections.emptyList():booklist;
		}
		
	// Implementation related to add books
		@PostMapping("/addNewBook")
		public Book addNewBook(@RequestBody Book b) {
			return bookservice.addBook(b);
		}
		
	// Implementation related to update book details
		@PutMapping("/updateBook/{id}")
		public Book updateBook(@PathVariable("id") int id,@RequestBody Book b) {
			return bookservice.updateBook(id, b);
		}		
		
	// Implementation related to delete specific book	
		@DeleteMapping("/deleteBook/{id}")
		public List<Book> deleteBook(@PathVariable("id") int id){
			return bookservice.deleteBook(id);
		}

}



