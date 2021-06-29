/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.entity.UsuarioEmpleado;
import ar.edu.unju.fi.repository.UsuarioRepository;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UsuarioEmpleado usuario;

	@Autowired private UsuarioRepository usuarioRepository;

	@GetMapping("/login")
	public String getSignInPage(Model model, Authentication auth) {
		model.addAttribute("usuario", usuario);
		return "signin";
	}

}
