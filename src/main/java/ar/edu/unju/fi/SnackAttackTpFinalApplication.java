package ar.edu.unju.fi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Snack Attack
 * 
 * Enzo Aramayo https://github.com/enzosandoval
 * Andrés Chaile https://github.com/andres777c
 * Gabriel Matías Sardina https://github.com/matiasard
 * Gabriel Molina https://github.com/gabrielmol92
 * 
 */
@SpringBootApplication
public class SnackAttackTpFinalApplication implements CommandLineRunner {

//	@Autowired
//	private Employee empleado;
//
//	@Autowired
//	private IEmployeeService empleadoService;
//	
//	@Autowired
//	private Office oficina;
//	
//	@Autowired
//	private IOfficeService officeService;

	public static void main(String[] args) {
		SpringApplication.run(SnackAttackTpFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		empleado.setFirstName("Enzo");
//		empleado.setLastName("Sandoval");
//		empleado.setEmail("enzosandoval@hotmail.com");
//		empleado.setJobTitle("Sales Rep");
//		
//		oficina = officeService.buscarOficina(1L);
//		
//		
//		empleado.setOffice(oficina);
//		empleado.setExtension("x5800");
//		empleado.setReportsTo(null);
//
//		UsuarioEmpleado usuario = new UsuarioEmpleado();
//		usuario.setUsername("usuario");
//		usuario.setPassword("usuario");
//		usuario.setImage(
//				"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");
//		usuario.setRol(EnumRoles.ROL_VENDEDOR.getDescripcion());
//		empleado.setUsuarioEmpleado(usuario);
//		empleadoService.guardar(empleado);
	}

}
