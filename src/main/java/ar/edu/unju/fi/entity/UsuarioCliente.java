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
@DiscriminatorValue(value = "Cliente")
@JsonTypeName("cliente")
public class UsuarioCliente extends Usuario {

	@OneToOne(mappedBy = "usuarioCliente", fetch = FetchType.LAZY)
	private Customer customer;

	public UsuarioCliente() {
		super();
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
