package com.bookstore.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
//	@ManyToOne
//	@JoinColumn(name = "userId",nullable=false)
	private int userId;
	private int bookId;
	private int quantity;
	private Date date;
	private String orderStatus;
	private boolean inCart;
	private boolean purchased;
	
	public Orders() {
		
	}
	
	
	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	

	public boolean isInCart() {
		return inCart;
	}


	public void setInCart(boolean inCart) {
		this.inCart = inCart;
	}


	public boolean isPurchased() {
		return purchased;
	}


	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}


	@Override
	public String toString() {
		return "OrderHistoryInfo [orderId=" + orderId + ", userId=" + userId + ", bookId=" + bookId + ", date=" + date
				+ ", orderStatus=" + orderStatus + "]";
	}

	
	public Orders(int orderId, int userId, int bookId, Date date, String orderStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.bookId = bookId;
		this.date = date;
		this.orderStatus = orderStatus;
	}
	
}



