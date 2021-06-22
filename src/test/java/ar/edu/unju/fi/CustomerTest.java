package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Customer;
import ar.edu.unju.fi.entity.Employee;
import ar.edu.unju.fi.service.ICustomerService;
import ar.edu.unju.fi.service.IEmployeeService;

@SpringBootTest
class CustomerTest {

	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	ICustomerService customerService;
	
	@Test
	void test() throws Exception {
		
		BigDecimal bd = new BigDecimal("12345678.99");
		Employee employee = employeeService.buscarEmpleado((long) 1002);
		Customer customer = new Customer();
		customer.setNumber((long) 100);
		customer.setAddressLine1("San Andreas St 290");
		customer.setAddressLine2("St Eint 120");
		customer.setCity("Los Angeles");
		customer.setContactFirstName("George");
		customer.setContactLastName("Richarlison");
		customer.setCountry("USA");
		customer.setCreditLimit(bd);
		customer.setName("The Roll Gifts");
		customer.setPhone("59 042 124");
		customer.setPostalCode("90001");
		customer.setSalesRepresentative(employee);
		customer.setState("California");
		customerService.guardar(customer);
		
	    assertEquals((long)100,customer.getNumber());
	}

}
