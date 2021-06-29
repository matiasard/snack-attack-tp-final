/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.entity.UsuarioEmpleado;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UsuarioEmpleado usuario;

	@GetMapping("/login")
	public String getSignInPage(Model model) {
		model.addAttribute("usuario", usuario);
		return "signin";
	}

}
