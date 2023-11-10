package com.Restaurant.service;

import java.util.List;

import com.Restaurant.entities.OrderItems;


public interface OrderItemsService {
	OrderItems AddOrderItems(OrderItems orderitems);

	List<OrderItems> getAllOrderItems();
	
	OrderItems getOrderItemsById(int orderItemId);
	
	OrderItems updateOrderItems(int orderItemId, OrderItems orderitems);

	String deleteOrderItemsById(int orderItemId);

	String deleteOrderItems();
}
