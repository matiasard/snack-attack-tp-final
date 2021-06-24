/**
 * 
 */
package ar.edu.unju.fi.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Enzo Sandoval
 *
 */
@Entity
@Component
@DiscriminatorValue(value = "Empleado")
@JsonTypeName("empleado")
public class UsuarioEmpleado extends Usuario {

	@OneToOne(mappedBy = "usuarioEmpleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Employee employee;

	public UsuarioEmpleado() {
		super();
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
