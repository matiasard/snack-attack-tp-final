package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Customer;
import ar.edu.unju.fi.entity.Order;
import ar.edu.unju.fi.entity.OrderDetails;
import ar.edu.unju.fi.service.ICustomerService;
import ar.edu.unju.fi.service.IOrderDetailsService;
import ar.edu.unju.fi.service.IOrderService;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class OrderTest {

   @Autowired
   IOrderService orderService;
	
   @Autowired
   ICustomerService customerService;
   
   @Autowired
   IOrderDetailsService orderDetailsService;
   
	
	@Test
	void testSaveOrder() throws Exception {
		
		
		Customer customer = customerService.buscarCliente((long) 103);
	
	    List<OrderDetails> orderDetails = orderDetailsService.obtenerOrderDetails(3);
		Order order = new Order();
		order.setNumber((long)10000);
		order.setComments("Check on availability.");
		order.setCustomer(customer);
		order.setOrderDate(LocalDate.of(2021, 01, 10));
		order.setOrderDetailsList(orderDetails);
		order.setRequiredDate(LocalDate.of(2021, 03, 19));
		order.setShippedDate(LocalDate.of(2021, 03, 10));
		order.setStatus("Shipped");
		orderService.guardar(order);		
		assertEquals((long)10000,order.getNumber());
	}

}
