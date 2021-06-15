/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Product;

/**
 * @author Enzo Sandoval
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
}
