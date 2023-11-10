package com.Restaurant.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.Delivery;
import com.Restaurant.repository.DeliveryRepository;
import com.Restaurant.service.DeliverService;

@Service
public class DeliveryServiceImp implements DeliverService {

	@Autowired
	DeliveryRepository td;

	@Override
	public Delivery AddDelivery(Delivery delivery) {

		return td.save(delivery);
	}

	@Override
	public List<Delivery> getAllDeliveryDetails() {
		List<Delivery> le = td.findAll();
		return le;
	}
	@Override
	public Delivery getDeliveryById(int deliveryid) {
		Delivery s = td.findById(deliveryid).get();
		return s;
	}
	@Override
	public Delivery updateDelivery(int deliveryid, Delivery delivery) {
		Delivery s = td.findById(deliveryid).get();
		
		s.setPaymentMode(delivery.getPaymentMode());
		s.setAmountToBeCollected(delivery.getAmountToBeCollected());
		s.setNumberOfItems(delivery.getNumberOfItems());
		s.setDeliverydate(delivery.getDeliverydate());


		return td.save(s);
	}

	@Override
	public String deleteDeliveryById(int deliveryid) {
		td.deleteById(deliveryid);
		return "Delivery is deleted";
	}

	@Override
	public String deleteDelivery() {
		td.deleteAll();
		return "All the Delivery are deleted";
	}

}