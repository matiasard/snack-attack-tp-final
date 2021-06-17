/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Enzo Sandoval
 *
 */
@Controller
public class UserController {

	@GetMapping("/signin")
	public String getSignInPage() {
		return "signin";
	}

	@GetMapping("/signup")
	public String getSignUpPage() {
		return "signup";
	}

}
