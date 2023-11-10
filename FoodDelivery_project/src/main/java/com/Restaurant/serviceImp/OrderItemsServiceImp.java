package com.Restaurant.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.OrderItems;
import com.Restaurant.repository.OrderItemRepository;
import com.Restaurant.service.OrderItemsService;

@Service
public class OrderItemsServiceImp implements OrderItemsService {
	@Autowired
	OrderItemRepository tb;

	@Override
	public OrderItems AddOrderItems(OrderItems orderitems) {

		return tb.save(orderitems);
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
		List<OrderItems> le = tb.findAll();
		return le;
	}
	@Override
	public OrderItems getOrderItemsById(int orderItemId) {
		OrderItems s = tb.findById(orderItemId).get();
		return s;
	}

	@Override
	public OrderItems updateOrderItems(int orderItemId, OrderItems orderitems) {
		OrderItems s = tb.findById(orderItemId).get();
		s.setFood(orderitems.getFood());
		s.setOrderItemId(orderitems.getOrderItemId());
		s.setFoodName(orderitems.getFoodName());
		s.setQuantity(orderitems.getQuantity());
		s.setPrice(orderitems.getPrice());
		
       return tb.save(s);
	}

	@Override
	public String deleteOrderItemsById(int orderItemId) {
		tb.deleteById(orderItemId);
		return "Order Oitems is deleted";
	}

	@Override
	public String deleteOrderItems() {
		tb.deleteAll();
		return "All the Order Oitems are deleted";
	}
}