package com.bookstore.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.User;
import com.bookstore.service.UserService;


	/*Implemented By Habib*/

@RestController
@RequestMapping("user")
public class UserController {
	UserService userService;
	
	@PostMapping("/add")
	public User addUser(User user) {
			
		return userService.createUser(user);

	}
	
	@GetMapping("/addAllUser")
	public List<User> getAllUser() {
		List<User> userList = userService.getAllUsers();
		
		if( userList!=null && !userList.isEmpty() )
				return  userList;
				
		else
			return Collections.emptyList();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<User> findById(@PathVariable("id") long id){
		
		Optional<User> user = userService.getUserById(id);
		
		if( user!=null && !user.isEmpty() )
			return  user;
			
	else
		return Optional.empty();
		
		
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeUserId(@PathVariable("id") long id) {
		
		userService.deleteUser(id);
		
	}
	
}