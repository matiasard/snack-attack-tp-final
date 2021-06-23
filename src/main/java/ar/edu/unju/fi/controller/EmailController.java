/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.service.imp.MailService;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class EmailController {

	@Autowired
	private MailService mailService;

	@PostMapping("/send/mail")
	public String sendMail(@RequestParam("EMAIL") String email) {
		String message = "Datos de contacto: " + email + "\nNombre: "+ email + "\nE-mail: " + email;
		mailService.sendMail(email, "programacion.visual.1996@gmail.com", email, message);
		return "redirect:/";
	}

}