/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Payment;

/**
 * @author Enzo Sandoval
 *
 */
public interface IPaymentService {

	public List<Payment> obtenerPagos();
	
}
