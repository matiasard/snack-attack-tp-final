/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Payment;

/**
 * @author Enzo Sandoval
 *
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
