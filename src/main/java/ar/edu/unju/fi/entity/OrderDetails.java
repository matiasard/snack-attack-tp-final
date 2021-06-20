/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

/**
 * @author Enzo Sandoval
 *
 */
@Entity
@Component
@Table(name = "orderdetails")
public class OrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailsId id;

	@NotNull
	//@Length(max = 11)
	@Column
	private Integer quantityOrdered;

	@NotNull
	@Column
	private BigDecimal priceEach;

	@NotNull
	@Column(length = 6)
	private Integer orderLineNumber;

	public OrderDetails() {
	}

	/**
	 * @return the id
	 */
	public OrderDetailsId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OrderDetailsId id) {
		this.id = id;
	}
	
	/**
	 * @return the quantityOrdered
	 */
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 * @return the priceEach
	 */
	public BigDecimal getPriceEach() {
		return priceEach;
	}

	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}

	/**
	 * @return the orderLineNumber
	 */
	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}

	/**
	 * @param orderLineNumber the orderLineNumber to set
	 */
	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach
				+ ", orderLineNumber=" + orderLineNumber + "]";
	}

}
