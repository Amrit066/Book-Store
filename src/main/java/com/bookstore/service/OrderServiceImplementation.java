package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.OrderRepository;
import com.bookstore.model.Orders;

import java.util.List;
import java.util.Optional;

@Service
	public class OrderServiceImplementation implements OrderService {

	    @Autowired
	    private OrderRepository orderRepository;

//	    @Autowired
//	    private OrderRepository orderItemRepository;

	    @Override
	    public List<Orders> getCartItems(int userId) {
			List<Orders> od = orderRepository.findByInCartAndUserId(true,userId);
	        
			return od.isEmpty()?null:od;
	    }

		@Override
		public Orders createOrder(Orders order) {
			return orderRepository.save(order);
		}

		@Override
		public List<Orders> getAllOrders() {
			return orderRepository.findAll();
		}

		@Override
		public Optional<Orders> getOrderById(int orderId) {
			 return orderRepository.findByOrderId(orderId);
		}

		

		@Override
		public Optional<Orders> getOrderedItemsByUser(int userId) {
			return orderRepository.findByUserId(userId);
			
		}

		
		@Override
		public Orders updateStatus(int orderId, String status) {
			Orders order = orderRepository.findByOrderId(orderId).get();
			order.setOrderStatus(status);
			orderRepository.save(order);
			return order;
			
		}

		@Override
		public void deleteOrder(int orderId) {
//			Optional<Order> order = getOrder(orderId);
//			orderRepository.deleteByOrderId(orderId);
			orderRepository.deleteById(orderId);
			
		}
		
		@Override
	    public Orders decreaseOrderQuantity(int orderId) {
			Orders od = orderRepository.findByOrderId(orderId).get();
			od.setQuantity(od.getQuantity()-1);
			orderRepository.save(od);
			return od;
		}

		@Override
		public Orders increaseOrderQuantity(int orderId) {
			Orders od = orderRepository.findByOrderId(orderId).get();
			od.setQuantity(od.getQuantity()+1);
			orderRepository.save(od);
			return od;
			
		}

		@Override
		public List<Orders> getPurchasedItems(int userId) {
			List<Orders> od = orderRepository.findByPurchasedAndUserId(true,userId);
	        
			return od.isEmpty()?null:od;
		}

		

	}
	

