/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.entity.Product;
import ar.edu.unju.fi.repository.ProductRepository;
import ar.edu.unju.fi.service.IProductService;

/**
 * @author Enzo Sandoval
 *
 */
@Service
public class ProductServiceImp implements IProductService {

	private static final Log LOGGER = LogFactory.getLog(ProductServiceImp.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void guardar(Product producto) {
		LOGGER.info("SERVICE: ProductService");
		LOGGER.info("METHOD: guardar()");
		productRepository.save(producto);
		LOGGER.info("RESULT: Se guardó el producto " + producto.getName());
	}

	@Override
	public List<Product> obtenerProductos() {
		LOGGER.info("SERVICE: ProductService");
		LOGGER.info("METHOD: obtenerProductos()");
		List<Product> productos = new ArrayList<>();
		productRepository.findAll().forEach(productos::add);
		LOGGER.info("METHOD: Lista tamaño: " + productos.size());
		return productos;
	}

	@Override
	public Product buscarProducto(String id) throws Exception {
		LOGGER.info("SERVICE: ProductService");
		LOGGER.info("METHOD: buscarProducto()");
		Optional<Product> optional = productRepository.findById(id);
		Product producto = null;
		if (optional.isPresent()) {
			producto = optional.get();
			LOGGER.info("RESULT: Producto: " + producto.getName());
		} else {
			throw new Exception("Producto no encontrado");
		}
		return producto;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAll(Pageable pagable) {
		LOGGER.info("SERVICE: ProductService");
		LOGGER.info("METHOD: findAll()");
		LOGGER.info("RESULT: Página de productos");
		return productRepository.findAll(pagable);
	}

	@Override
	public void borrar(String id) {
		LOGGER.info("SERVICE: ProductService");
		LOGGER.info("METHOD: borrar()");
		LOGGER.info("RESULT: ");
		productRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findByKeyword(String keyword) {
		LOGGER.info("METHOD: findByKeyword()");
		return productRepository.findByKeyword(keyword);
	}

	
}
