package com.Restaurant.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.Orders;
import com.Restaurant.repository.OrdersRepository;
import com.Restaurant.service.OrdersService;

@Service

public class OrdersServiceImp implements OrdersService {

	@Autowired
	OrdersRepository ord;

	@Override
	public Orders AddOrders(Orders orders) {

		return ord.save(orders);
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> le = ord.findAll();
		return le;
	}
	
	@Override
	public Orders getOrdersById(int orderId) {
		Orders s = ord.findById(orderId).get();
		return s;
	}

	@Override
	public Orders updateOrders(int orderId, Orders orders) {
		Orders s = ord.findById(orderId).get();
		//s.setOrderItems(orders.getOrderItems());
		s.setTotalPrice(orders.getTotalPrice());
		s.setTotalQuantity(orders.getTotalQuantity());
		//s.setPayment(orders.getPayment());
		s.setOrderId(orders.getOrderId());

		return ord.save(s);
	}

	@Override
	public String deleteOrdersById(int orderId) {
		ord.deleteById(orderId);
		return "Order is deleted";
	}

	@Override
	public String deleteOrders() {
		ord.deleteAll();
		return "All the orders are deleted";
	}

}