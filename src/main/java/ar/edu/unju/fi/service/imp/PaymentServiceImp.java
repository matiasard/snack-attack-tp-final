/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Payment;
import ar.edu.unju.fi.repository.PaymentRepository;
import ar.edu.unju.fi.service.IPaymentService;

/**
 * @author Enzo Sandoval
 *
 */
@Service
public class PaymentServiceImp implements IPaymentService {
	
	private static final Log LOGGER = LogFactory.getLog(PaymentServiceImp.class);

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> obtenerPagos() {
		LOGGER.info("SERVICE: PaymentService");
		LOGGER.info("METHOD: obtenerPagos()");
		List<Payment> pagos = new ArrayList<>();
		paymentRepository.findAll().forEach(pagos::add);
		LOGGER.info("METHOD: Lista tamaño: " + pagos.size());
		return pagos;
	}

}
