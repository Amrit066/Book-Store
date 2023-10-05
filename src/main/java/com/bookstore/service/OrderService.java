package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.bookstore.model.Orders;


public interface OrderService {
	
	// Create and add a new order to the system.
    Orders createOrder(Orders order);

    // Retrieve a list of all orders in the system.
    List<Orders> getAllOrders();

    // Retrieve a specific order by its unique orderId.
    Optional<Orders> getOrderById(int orderId);

    // Retrieve a list of cart items for a specific user based on userId.
    List<Orders> getCartItems(int userId);
    
    // Retrieve a list of cart items for a specific user based on userId.
    List<Orders> getPurchasedItems(int userId);

    // Retrieve a list of ordered items for a specific user based on userId.
    Optional<Orders> getOrderedItemsByUser(int userId);

   // Update the status of a specific order.
    Orders updateStatus(int orderId, String status);

    // Remove a specific order and its associated items from the system.
    void deleteOrder(int orderId);
    
    // Decrease quantity of a specific order and its associated items from the system.
    Orders decreaseOrderQuantity(int orderId);
    
    // Increase quantity of a specific order and its associated items from the system.
    Orders increaseOrderQuantity(int orderId);
}

