package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Employee;
import ar.edu.unju.fi.entity.Office;
import ar.edu.unju.fi.service.IEmployeeService;
import ar.edu.unju.fi.service.IOfficeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	IOfficeService officeService;
	
	@Autowired
	IEmployeeService employeeService;
	
	
	@Test
	void test() throws Exception {
		
		Office office = officeService.buscarOficina((long) 1); 
		Employee RepEmployeeTo = employeeService.buscarEmpleado((long)1002);
		Employee employee = new Employee();
		employee.setNumber((long)1177);
		employee.setEmail("mgreenw@gmail.com");
		employee.setExtension("x5567");
		employee.setFirstName("Michael");
		employee.setJobTitle("Sales Rep");
		employee.setLastName("Greenwood");
		employee.setOffice(office);
		employee.setReportsTo(RepEmployeeTo);
		employeeService.guardar(employee);
		
		assertEquals("x5567",employee.getExtension());
	}
	
}

