/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;

/**
 * @author Enzo Sandoval
 *
 */
@Entity
@Component
@Table(name = "orderdetails")
@EqualsAndHashCode(of = "id")
public class OrderDetails {

	@EmbeddedId
	private OrderDetailsId id;

	@NotBlank
	@Length(max = 11)
	@Column(nullable = false, length = 11)
	private Integer quantityOrdered;

	@NotBlank
	@Column(nullable = false)
	private BigDecimal priceEach;

	@NotBlank
	@Length(max = 6)
	@Column(nullable = false, length = 6)
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
