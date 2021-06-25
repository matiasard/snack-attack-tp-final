/**
 * 
 */
package ar.edu.unju.fi.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.service.IProductLinesService;
import ar.edu.unju.fi.service.IProductService;

import org.springframework.ui.Model;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class GraphController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IProductLinesService productLinesService;

	@GetMapping("/statistics")
	public String barGraph(Model model) throws Exception {

		int total = productService.obtenerProductos().size();

		Map<String, Integer> surveyMap = new LinkedHashMap<>();

		surveyMap.put("Classic Cars",
				productLinesService.buscarLineaDeProducto("Classic Cars").getProductos().size() * 100 / total);
		surveyMap.put("Motorcycles",
				productLinesService.buscarLineaDeProducto("Motorcycles").getProductos().size() * 100 / total);
		surveyMap.put("Planes",
				productLinesService.buscarLineaDeProducto("Planes").getProductos().size() * 100 / total);
		surveyMap.put("Ships", productLinesService.buscarLineaDeProducto("Ships").getProductos().size() * 100 / total);
		surveyMap.put("Trains",
				productLinesService.buscarLineaDeProducto("Trains").getProductos().size() * 100 / total);
		surveyMap.put("Trucks and Buses",
				productLinesService.buscarLineaDeProducto("Trucks and Buses").getProductos().size() * 100 / total);
		surveyMap.put("Vintage Cars",
				productLinesService.buscarLineaDeProducto("Vintage Cars").getProductos().size() * 100 / total);
		model.addAttribute("surveyMap", surveyMap);

		model.addAttribute("surveyMap", surveyMap);
		return "statistics";
	}

}
