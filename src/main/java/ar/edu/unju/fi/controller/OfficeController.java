/**
 * 
 */
package ar.edu.unju.fi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.Office;
import ar.edu.unju.fi.service.IOfficeService;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class OfficeController {

	@Autowired
	private Office office;

	@Autowired
	private IOfficeService officeService;

	@GetMapping("/offices")
	public String getOfficesPage(@RequestParam Map<String, Object> params, Model model) {
		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
		PageRequest pageRequest = PageRequest.of(page, 10);
		Page<Office> pageOffices = officeService.findAll(pageRequest);
		int totalPage = pageOffices.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("offices", pageOffices.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		return "office-crud";
	}

	@GetMapping("/office/edit/{code}")
	public String getEditOfficePage(@PathVariable(value = "code") long code, Model model) throws Exception {
		office = officeService.buscarOficina(code);
		model.addAttribute("office", office);
		return "office-edit";
	}

	@GetMapping("/office/new")
	public String getNewOfficePage(Model model) throws Exception {
		office = new Office();
		model.addAttribute("office", office);
		return "office-edit";
	}

	@PostMapping(value = "/office/save")
	public String getSaveOfficeAndRedirect(@Valid @ModelAttribute("office") Office office, BindingResult result,
			Model model) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("product", office);
			return "office-edit";
		} else {
			officeService.guardar(office);
			return "redirect:/offices";
		}
	}

	/**
	 * 
	 * @param code
	 * @return Oficina eliminada
	 */
	@GetMapping(value = "/office/delete/{code}")
	public String delete(@PathVariable(value = "code") long code) {
		officeService.borrar(code);
		return "redirect:/offices";
	}

	/**
	 * 
	 * @return Las oficinas ubicadas en Argentina a nuestra app móvil
	 * @throws Exception
	 */
	@GetMapping("/our/offices")
	public ResponseEntity<Object> getOficinasEnArgentina() throws Exception {
		List<Office> oficinas = new ArrayList<>();
		oficinas = officeService.buscarOficinasPorPais("Argentina");
		if (!oficinas.isEmpty()) {
			return ResponseEntity.ok(oficinas.toArray());
		}
		return ResponseEntity.notFound().build();
	}

}
