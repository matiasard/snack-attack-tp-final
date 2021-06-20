package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Product;
import ar.edu.unju.fi.entity.ProductLines;
import ar.edu.unju.fi.service.IProductLinesService;
import ar.edu.unju.fi.service.IProductService;

@SpringBootTest
class ProductLineTest {
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IProductLinesService productLineService;
	
	
	@Test
	void test() throws Exception {
		
		List<Product> products = new ArrayList<Product>();
		Product product1 = productService.buscarProducto("S10_1949");
		Product product2 = productService.buscarProducto("S10_1678");
		products.add(product2);
		products.add(product1);
		ProductLines productLine = new ProductLines();
		productLine.setHtmlDescription("www.google.com");
		productLine.setImage("");
		productLine.setProductLine("Bikes");
		productLine.setTextDescription("Our bykes are state of the art replicas of classic and modern. Materials used include diecast and plastic. The models range in size from 1:10 to 1:50 scale and include numerous limited edition. All models come fully assembled and ready for display in the home or office.");
		productLine.setProductos(products);
	    productLineService.guardar(productLine);
		
		assertEquals("Bikes", productLine.getProductLine());
	}

}
