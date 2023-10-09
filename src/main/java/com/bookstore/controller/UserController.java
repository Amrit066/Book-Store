package com.bookstore.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Users;
import com.bookstore.service.UserService;


	/*Implemented By Habib*/

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public Users addUser(@RequestBody Users user) {
		System.out.println("Saving user info......");
		return userService.createUser(user);

	}
	
	@GetMapping("/getAllUser")
	public List<Users> getAllUser() {
		List<Users> userList = userService.getAllUsers();
		
		if( userList!=null && !userList.isEmpty() )
				return  userList;
				
		else
			return Collections.emptyList();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Users> findById(@PathVariable("id") long id){
		
		Optional<Users> user = userService.getUserById(id);
		
		if( user!=null && !user.isEmpty() )
			return  user;
			
	else
		return Optional.empty();
		
		
	}
	
	@PutMapping("/update/{id}")
	public Users updateUser(@PathVariable("id") long id, @RequestBody Users user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeUserId(@PathVariable("id") long id) {
		
		userService.deleteUser(id);
		
	}
	
}