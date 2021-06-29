/**
 * 
 */
package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Product;

/**
 * @author Enzo Sandoval
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
  
  // ✨ Consulta para la Barra de Busqueda 🔍
  @Query(value = "SELECT * FROM products p WHERE " + 
  "CONCAT(p.productName, p.productCode, p.productLine, p.productVendor)" + 
  " LIKE %:keyword%", nativeQuery = true)
  List<Product> findByKeyword(@Param("keyword") String keyword);
}
