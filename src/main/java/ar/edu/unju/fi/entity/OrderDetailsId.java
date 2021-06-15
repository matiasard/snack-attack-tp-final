/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;

/**
 * @author Enzo Sandoval
 *
 */
@EqualsAndHashCode
@Embeddable
public class OrderDetailsId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2142251149308551943L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "orderNumber", nullable = false)
	private Order order;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "productCode", nullable = false)
	private Product product;

	public OrderDetailsId() {
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

}
