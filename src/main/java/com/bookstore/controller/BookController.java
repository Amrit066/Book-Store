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
	@GetMapping("/gettAllBook")
	public List<Book> getAllBook(){
		
		System.out.println("Retreiving All Book Info.....");
		List<Book> booklist = bookservice.showAllBook();
		return booklist.isEmpty()?Collections.emptyList():booklist;
	}
	
	// Implementation to get info related to specific books
		// Based on title
		@GetMapping("/gettAllBook/{title}")
		public Book getBook(@PathVariable("title") String title){
			
			System.out.println("Retreiving Book Info with title -"+title);
			Book b = bookservice.showBook("title",title);
			return b;
		}

}



