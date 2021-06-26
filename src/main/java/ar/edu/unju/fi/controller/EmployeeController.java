package ar.edu.unju.fi.controller;

import java.io.IOException;
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

import ar.edu.unju.fi.entity.Employee;

import ar.edu.unju.fi.service.IEmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private Employee employee;

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/employees")
	public String getEmployeePage(@RequestParam Map<String, Object> params, Model model) {
		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
		PageRequest pageRequest = PageRequest.of(page, 10);
		Page<Employee> pageEmployees = employeeService.findAll(pageRequest);
		int totalPage = pageEmployees.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("employees", pageEmployees.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		return "employee-crud";
	}

	@GetMapping("/employee/edit/{id}")
	public String getEditEmployeePage(@PathVariable(value = "id") long id, Model model) throws Exception {
		employee = employeeService.buscarEmpleado(id);
		model.addAttribute("employee", employee);
		return "employee-edit";
	}

	@GetMapping("/employee/new")
	public String getNewEmployeePage(Model model) throws Exception {
		employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee-edit";
	}

	@PostMapping(value = "/employee/save")
	public String getSaveemployeeAndRedirect(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			Model model) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("employee", employee);
			return "employee-edit";
		} else {
			employeeService.guardar(employee);
			return "redirect:/employees";
		}
	}


	@GetMapping(value = "/employee/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		employeeService.borrar(id);
		return "redirect:/employees";
	}
	
}
