package ar.edu.unju.fi.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.OrderDetails;
import ar.edu.unju.fi.repository.OrderDetailsRepository;
import ar.edu.unju.fi.service.IOrderDetailsService;



@Service
public class OrderDetailsServiceImp implements IOrderDetailsService {

	@Autowired 
	OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public void guardar(OrderDetails orderDetails) {
		orderDetailsRepository.save(orderDetails);
	}

	@Override
	public List<OrderDetails> obtenerOrderDetails(int orderNumber) {
		List<OrderDetails>orderDetails = orderDetailsRepository.findByOrderLineNumber(orderNumber);
		return orderDetails;
	}

	

}
