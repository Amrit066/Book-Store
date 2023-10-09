package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;



import com.bookstore.dao.UserRepository;
import com.bookstore.model.Users;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	public UserService() {
		super();
	}

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Long userId) {
    	int id = Math.toIntExact(userId);    	
    	return userRepository.findById(id);
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(Long userId, Users updatedUser) {
    	int id = Math.toIntExact(userId);    
        Optional<Users> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            Users user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }

    public void deleteUser(Long userId) {
    	int id = Math.toIntExact(userId);    
        userRepository.deleteById(id);
    }
}