package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Order;
import ar.edu.unju.fi.entity.OrderDetails;
import ar.edu.unju.fi.entity.OrderDetailsId;
import ar.edu.unju.fi.entity.Product;
import ar.edu.unju.fi.service.IOrderDetailsService;
import ar.edu.unju.fi.service.IOrderService;
import ar.edu.unju.fi.service.IProductService;

@SpringBootTest
class OrderDetailsTest {

	@Autowired
	IProductService productService;
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IOrderDetailsService orderDetailsService;
	
	@Test
	void test() throws Exception {
		
		BigDecimal bd = new BigDecimal("100");
		
		Product product = productService.buscarProducto("S10_1678");
		Order order = orderService.buscarOrden(10100);
		OrderDetailsId orderDetailsId = new OrderDetailsId(order,product);
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setId(orderDetailsId);
		orderDetails.setOrderLineNumber(1);
		orderDetails.setPriceEach(bd);
		orderDetails.setQuantityOrdered(20);
		orderDetailsService.guardar(orderDetails);
		assertEquals(20,orderDetails.getQuantityOrdered());
	}

}
