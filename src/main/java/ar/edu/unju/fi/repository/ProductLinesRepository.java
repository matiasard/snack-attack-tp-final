/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.ProductLines;

/**
 * @author Enzo Sandoval
 *
 */
@Repository
public interface ProductLinesRepository extends JpaRepository<ProductLines, String> {

}
