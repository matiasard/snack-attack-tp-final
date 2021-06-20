package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Product;
import ar.edu.unju.fi.entity.ProductLines;
import ar.edu.unju.fi.service.IProductLinesService;
import ar.edu.unju.fi.service.IProductService;

@SpringBootTest
class ProductTest {

	@Autowired 
	IProductLinesService productLineService;
	
	@Autowired
	IProductService productService;
	
	@Test
	void testProductTest() throws Exception {
		
		BigDecimal bd1 = new BigDecimal("98.00");
		BigDecimal bd2 = new BigDecimal("150.00");
		
		ProductLines productline = productLineService.buscarLineaDeProducto("Planes");
		Product product =new Product();
		product.setBuyPrice(bd1);
		product.setDescription("The Airbus A350 is a long-range, wide-body jet airliner developed by Airbus. The first A350 design proposed by Airbus in 2004,would have been a development of the A330 with composite wings and new engines");
		product.setId("S10_1520");
		product.setImage(null);
		product.setMSRP(bd2);
		product.setName("2016 Boeing 737 MAX 8");
		product.setProductLine(productline);
		product.setScale("1:20");
		product.setVendor("Highway 120 Mini Modern Planes");
		product.setQuantityInStock(1543);
		productService.guardar(product);
		assertEquals("S10_1520",product.getId());
	}

}
