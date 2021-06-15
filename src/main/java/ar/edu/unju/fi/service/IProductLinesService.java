/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.edu.unju.fi.entity.ProductLines;

/**
 * @author Enzo Sandoval
 *
 */
public interface IProductLinesService {

	public void guardar(ProductLines productLine);

	public List<ProductLines> obtenerLineasDeProductos();

	public ProductLines buscarLineaDeProducto(String id) throws Exception;

	public Page<ProductLines> findAll(Pageable pagable);

	public void borrar(String id);
	
}
