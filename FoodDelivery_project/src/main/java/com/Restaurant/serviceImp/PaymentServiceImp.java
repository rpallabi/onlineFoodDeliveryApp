package com.Restaurant.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.Payment;
import com.Restaurant.repository.PaymentRepository;
import com.Restaurant.service.PaymentService;


@Service
public class PaymentServiceImp implements PaymentService {
	@Autowired
	PaymentRepository pmt;

	@Override
	public Payment CreatePayment(Payment payment) {

		return pmt.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> le = pmt.findAll();
		return le;
	}
	@Override
	public Payment getPaymentById(int pid) {
		Payment s = pmt.findById(pid).get();
		return s;
	}

	@Override
	public Payment updatePayment(int pid, Payment payment) {
		Payment s = pmt.findById(pid).get();
		
	
		

		return pmt.save(s);
	}

	@Override
	public String deletePaymentById(int pid) {
		pmt.deleteById(pid);
		return "payment is deleted";
	}

	@Override
	public String deletePayment() {
		pmt.deleteAll();
		return "All the Payments are deleted";
	}
}
