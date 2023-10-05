package com.bookstore.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;


//JpaRepository class for the Book Table
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
	List<Book> findByPrice(float price);

}