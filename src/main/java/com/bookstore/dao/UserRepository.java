package com.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.User;

	// Habib and Jayanth created User Repository interface

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}