package com.Restaurant.service;

import java.util.List;

import com.Restaurant.entities.Orders;


public interface OrdersService {
	Orders AddOrders(Orders orders);

	List<Orders> getAllOrders();
	
	Orders getOrdersById(int orderId);
	
	Orders updateOrders(int orderId, Orders orders);

	String deleteOrdersById(int orderId);

	String deleteOrders();
}
