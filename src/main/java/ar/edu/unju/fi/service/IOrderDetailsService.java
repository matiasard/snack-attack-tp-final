package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.OrderDetails;


public interface IOrderDetailsService {

	public void guardar (OrderDetails orderDetails);
	
	public List<OrderDetails> obtenerOrderDetails(int orderNumber);
}
