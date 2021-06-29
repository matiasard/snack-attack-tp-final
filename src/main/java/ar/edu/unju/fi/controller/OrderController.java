/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unju.fi.entity.Employee;
import ar.edu.unju.fi.service.ICustomerService;
import ar.edu.unju.fi.service.IEmployeeService;
import ar.edu.unju.fi.service.IOrderService;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class OrderController {

	@Autowired
	private IEmployeeService empleadoService;
	
	@Autowired
	private Employee empleadoLogueado;
	
	@Autowired
	private IOrderService ordenService;
	
	@Autowired
	private ICustomerService clienteService;
	
	
	
}
