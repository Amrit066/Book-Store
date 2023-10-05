package com.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Orders;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    // Custom query method to find orders by user ID
	Optional<Orders> findByUserId(int userId);
    Optional<Orders> findByOrderId(int orderId);
    Optional<Orders> findByBookId(int bookId);
	List<Orders>		findByInCartAndUserId(boolean bool ,int userId);
	List<Orders>		findByPurchasedAndUserId(boolean bool ,int userId);
	void deleteByOrderId(int orderId);

}
