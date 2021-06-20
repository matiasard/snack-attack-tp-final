/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;

/**
 * @author Enzo Sandoval
 *
 */
@Embeddable
public class OrderDetailsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@NotNull
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Order order;

	//@NotNull
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product product;

	public OrderDetailsId() {
	}
	
	public OrderDetailsId(Order order,Product product) {
		super();
		this.order = order;
		this.product = product;
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
