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

import ar.edu.unju.fi.entity.ProductLines;
import ar.edu.unju.fi.repository.ProductLinesRepository;
import ar.edu.unju.fi.service.IProductLinesService;

@Service
public class ProductLinesServiceImp implements IProductLinesService {

	private static final Log LOGGER = LogFactory.getLog(ProductLinesServiceImp.class);

	@Autowired
	private ProductLinesRepository productLinesRepository;

	@Override
	public void guardar(ProductLines productLine) {
		LOGGER.info("SERVICE: ProductLinesService");
		LOGGER.info("METHOD: guardar()");
		productLinesRepository.save(productLine);
		LOGGER.info("RESULT: Se guardó correctamente");
	}

	@Override
	public List<ProductLines> obtenerLineasDeProductos() {
		LOGGER.info("SERVICE: ProductLinesService");
		LOGGER.info("METHOD: obtenerLineasDeProductos()");
		List<ProductLines> lineas = new ArrayList<>();
		productLinesRepository.findAll().forEach(lineas::add);
		LOGGER.info("METHOD: Lista tamaño: " + lineas.size());
		return lineas;
	}

	@Override
	public ProductLines buscarLineaDeProducto(String id) throws Exception {
		LOGGER.info("SERVICE: ProductLinesService");
		LOGGER.info("METHOD: buscarLineaDeProducto()");
		Optional<ProductLines> optional = productLinesRepository.findById(id);
		ProductLines productLine = null;
		if (optional.isPresent()) {
			productLine = optional.get();
			LOGGER.info("RESULT: Linea ");
		} else {
			throw new Exception("Linea de Producto no encontrada");
		}
		return productLine;
	}

	@Override
	public Page<ProductLines> findAll(Pageable pagable) {
		LOGGER.info("SERVICE: ProductLineService");
		LOGGER.info("METHOD: findAll()");
		LOGGER.info("RESULT: Página de línea de productos");
		return productLinesRepository.findAll(pagable);
	}

	@Override
	public void borrar(String id) {
		LOGGER.info("SERVICE: ProductLinesService");
		LOGGER.info("METHOD: borrar()");
		LOGGER.info("RESULT: ");
		productLinesRepository.deleteById(id);
	}

}
