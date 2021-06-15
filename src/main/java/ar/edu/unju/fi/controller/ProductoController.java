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

import ar.edu.unju.fi.entity.Product;
import ar.edu.unju.fi.service.ICustomerService;
import ar.edu.unju.fi.service.IEmployeeService;
import ar.edu.unju.fi.service.IOfficeService;
import ar.edu.unju.fi.service.IOrderService;
import ar.edu.unju.fi.service.IPaymentService;
import ar.edu.unju.fi.service.IProductService;

/**
 * 
 * @author Enzo Sandoval
 *
 */
@Controller
public class ProductoController {

	@Autowired
	private Product product;

	@Autowired
	private IProductService productService;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private IOfficeService officeService;

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IPaymentService paymentService;

	@GetMapping("/")
	public String getHomePage(Model model) throws Exception {
		model.addAttribute("products", productService.obtenerProductos());
		model.addAttribute("customers", customerService.obtenerClientes());
		model.addAttribute("employees", employeeService.obtenerEmpleados());
		model.addAttribute("offices", officeService.obtenterOficinas());
		model.addAttribute("orders", orderService.obtenerOrdenes());
		model.addAttribute("payments", paymentService.obtenerPagos());
		return "home";
	}

//	@GetMapping("/producto")
//	public String getPage(Model model) {
//		producto = new Producto();
//		producto.setImagen("");
//		model.addAttribute(producto);
//		return "nuevo";
//	}
//
//	@GetMapping(value = "/producto/modificar/{id}")
//	public String getUpdatePage(@PathVariable(value = "id") int id, Model model) throws Exception {
//		producto = productoService.buscarProducto(id);
//		model.addAttribute("producto", producto);
//		return "nuevo";
//	}
//
//	@GetMapping("/productos")
//	public String findAll(@RequestParam Map<String, Object> params, Model model) {
//		model.addAttribute("producto", producto);
//		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
//		PageRequest pageRequest = PageRequest.of(page, 5);
//		Page<Producto> pageProducto = productoService.findAll(pageRequest);
//		int totalPage = pageProducto.getTotalPages();
//		if (totalPage > 0) {
//			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
//			model.addAttribute("pages", pages);
//		}
//		model.addAttribute("productos", pageProducto.getContent());
//		model.addAttribute("current", page + 1);
//		model.addAttribute("next", page + 2);
//		model.addAttribute("prev", page);
//		model.addAttribute("last", totalPage);
//
//		return "productos";
//	}
//
//	@PostMapping(value = "/producto/guardar", consumes = "multipart/form-data")
//	public String getResultado(@RequestParam("file") MultipartFile file,
//			@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model)
//			throws IOException {
//		System.out.println("Imagen" + producto.getImagen());
//		if (result.hasErrors()) {
//			model.addAttribute("producto", producto);
//			return "nuevo";
//		} else {
//			if (!file.isEmpty()) {
//				byte[] content = file.getBytes();
//				String base64 = Base64.getEncoder().encodeToString(content);
//				producto.setImagen(base64);
//			}
//			productoService.guardar(producto);
//			return "redirect:/productos";
//		}
//	}
//
//	@GetMapping(value = "/delete/{id}")
//	public String delete(@PathVariable(value = "id") int id) {
//		productoService.borrar(id);
//		return "redirect:/productos";
//	}
//
//	@GetMapping("/producto/ultimo")
//	public String getUltimoProducto(Model map) throws Exception {
//		map.addAttribute("producto", productoService.obtenerUltimo());
//		return "ultimoproducto";
//	}

}
