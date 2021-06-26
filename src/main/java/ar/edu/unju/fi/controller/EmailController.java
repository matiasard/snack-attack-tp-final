/**
 * 
 */
package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.service.imp.MailServiceImp;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class EmailController {

	@Autowired
	private MailServiceImp mailServiceImp;

	@PostMapping("/send/mail")
	public String sendMail(@Valid @RequestParam("EMAIL") String email) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "mail");
		String message = "Datos de contacto: Cliente from classicmodelscars \nNombre: Cliente\nE-mail: " + email;
		mailServiceImp.sendMail(email, "programacion.visual.1996@gmail.com", email, message);
		return "redirect:/";
	}

}