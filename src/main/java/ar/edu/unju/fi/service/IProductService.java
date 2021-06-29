/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.edu.unju.fi.entity.Product;

/**
 * @author Enzo Sandoval
 *
 */
public interface IProductService {

	public void guardar(Product producto);

	public List<Product> obtenerProductos();

	public Product buscarProducto(String id) throws Exception;

	public Page<Product> findAll(Pageable pagable);

	public void borrar(String id);

	public List<Product> findByKeyword(String keyword);

}
