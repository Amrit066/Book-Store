package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstore.model.Orders;
import com.bookstore.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderService orderItemService;

    // Create a new order
    @PostMapping("/create")
    public Orders createOrder(@RequestBody Orders order) {
        Orders createdOrder = orderService.createOrder(order);
        return createdOrder;
    }

    // Retrieve all orders
    @GetMapping("/allOrders")
    public List<Orders> getAllOrders() {
        List<Orders> orders = orderService.getAllOrders();
        return orders;
    }

    // Retrieve a specific order by order ID
    @GetMapping("/{orderId}")
    public Optional<Orders> getOrderById(@PathVariable int orderId) {
        Optional<Orders> order = orderService.getOrderById(orderId);
        return order;
    }


    // Retrieve cart items for a specific user based on userId
    @GetMapping("/cart/{userId}")
    public List<Orders> getCartItems(@PathVariable int userId) {
        List<Orders> cartItems = orderItemService.getCartItems(userId);
        return cartItems.isEmpty()?null:cartItems;
    }
    
    // Retrieve cart items for a specific user based on userId
    @GetMapping("/purchased/{userId}")
    public List<Orders> getPurchasedItems(@PathVariable int userId) {
        List<Orders> cartItems = orderItemService.getPurchasedItems(userId);
        return cartItems.isEmpty()?null:cartItems;
    }

    // Retrieve ordered items for a specific user based on userId
    @GetMapping("/ordered/{userId}")
    public Optional<Orders> getOrderedItems(@PathVariable int userId) {
        Optional<Orders> orderedItems = orderItemService.getOrderedItemsByUser(userId);
        return orderedItems;
    }
    
    // Update the status of a specific order
    @PatchMapping("/status/{orderId}")
    public Orders updateOrderStatus(
            @PathVariable int orderId,
            @RequestParam String status) {
        Orders updatedOrder = orderService.updateStatus(orderId, status);
        return updatedOrder;
    }
    
    // Increase the quantity of a specific order
    @PatchMapping("/increaseQuantity/{orderId}")
    public Orders increaseOrderQuantity(@PathVariable int orderId) {
        Orders updatedOrder = orderService.increaseOrderQuantity(orderId);
        return updatedOrder;
    }
    
    // Decrease the quantity of a specific order
    @PatchMapping("/decreaseQuantity/{orderId}")
    public Orders decreaseOrderQuantity(@PathVariable int orderId) {
        Orders updatedOrder = orderService.decreaseOrderQuantity(orderId);
        return updatedOrder;
    }

    // Delete a specific order by order ID
    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable ("orderId") int orderId) {
    	 orderService.deleteOrder(orderId);
        
    }
}



