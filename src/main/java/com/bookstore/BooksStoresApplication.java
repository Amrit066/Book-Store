package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Jayanth added Swagger Import
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BooksStoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksStoresApplication.class, args);
	}

}
