package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Customer;
import ar.edu.unju.fi.entity.Payment;
import ar.edu.unju.fi.service.ICustomerService;
import ar.edu.unju.fi.service.IPaymentService;

@SpringBootTest
class PaymentTest {

	@Autowired
	IPaymentService paymentService;
	
	@Autowired
	ICustomerService customerService;
	
	@Test
	void test() throws Exception {

        BigDecimal bd = new BigDecimal("6000");
		Customer customer = customerService.buscarCliente((long) 103);
		Payment payment = new Payment();
		payment.setId("HQ100100");
		payment.setAmount(bd);
		payment.setCustomer(customer);
		payment.setPaymentDate(LocalDate.of(2021, 04, 10));
		paymentService.guardar(payment);
		assertEquals("HQ100100",payment.getId());
	}

}
