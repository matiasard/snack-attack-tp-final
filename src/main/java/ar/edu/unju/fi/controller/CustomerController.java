/**
 * 
 */
package ar.edu.unju.fi.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.entity.Customer;
import ar.edu.unju.fi.service.ICustomerService;
import ar.edu.unju.fi.service.IEmployeeService;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private Customer customer;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/customers")
	public String getCustomersPage(@RequestParam Map<String, Object> params, Model model) {
		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
		PageRequest pageRequest = PageRequest.of(page, 10);
		Page<Customer> pageCustomers = customerService.findAll(pageRequest);
		int totalPage = pageCustomers.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("customers", pageCustomers.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		return "customer-crud";
	}

	@GetMapping("/customer/edit/{id}")
	public String getEditCustomerPage(@PathVariable(value = "id") long id, Model model) throws Exception {
		customer = customerService.buscarCliente(id);
		model.addAttribute("customer", customer);
		model.addAttribute("employess", employeeService.obtenerEmpleados());
		return "customer-edit";
	}

	@GetMapping("/customer/new")
	public String getNewCustomerPage(Model model) throws Exception {
		customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("employess", employeeService.obtenerEmpleados());
		return "customer-edit";
	}

	@PostMapping(value = "/customer/save", consumes = "multipart/form-data")
	public String getSaveCustomerAndRedirect(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model)
			throws IOException {
		if (!file.isEmpty()) {
			byte[] content = file.getBytes();
			String base64 = Base64.getEncoder().encodeToString(content);
			customer.getUsuarioCliente().setImage(base64);
		}
		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "customer-edit";
		} else {
			customerService.guardar(customer);
			return "redirect:/customers";
		}
	}

	@GetMapping(value = "/customer/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		customerService.borrar(id);
		return "redirect:/customers";
	}

}
