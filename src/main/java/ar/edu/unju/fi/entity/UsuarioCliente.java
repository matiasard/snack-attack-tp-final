/**
 * 
 */
package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Enzo Sandoval
 *
 */
@Entity
@Component
@DiscriminatorValue(value = "Cliente")
@JsonTypeName("cliente")
public class UsuarioCliente extends Usuario {

	private String rol;

	@Email(message = "Invalid email format ")
	@NotBlank(message = "You must enter an email address ")
	@Length(max = 100)
	@Column(name = "email", nullable = false, length = 100, unique = true, updatable = true)
	private String email;

	@OneToOne(mappedBy = "usuarioCliente", fetch = FetchType.LAZY)
	private Customer customer;

	public UsuarioCliente() {
		super();
		this.rol = "cliente";
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
