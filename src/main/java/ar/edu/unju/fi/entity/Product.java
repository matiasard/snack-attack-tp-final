/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

/**
 * @author Enzo Sandoval
 *
 */
@Entity
@Component
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "productCode", unique = true, nullable = false, updatable = false)
	private String code;

	@NotBlank
	@Length(max = 70)
	@Column(name = "productName", nullable = false, length = 70)
	private String name;

	@NotBlank
	@Length(max = 10)
	@Column(name = "productScale", nullable = false, length = 10)
	private String scale;

	@NotBlank
	@Length(max = 50)
	@Column(name = "productVendor", nullable = false, length = 50)
	private String vendor;

	@NotBlank
	@Column(name = "productDescription", nullable = false)
	private String description;

	@NotBlank
	@Length(max = 6)
	@Column(nullable = false, length = 6)
	private Integer quantityInStock;

	@NotBlank
	@Column(nullable = false)
	private BigDecimal buyPrice;

	@NotBlank
	@Column(nullable = false)
	private BigDecimal MSRP;

	@ManyToOne
	@JoinColumn(name = "productLine")
	private ProductLines productLines;

	public Product() {
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the scale
	 */
	public String getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantityInStock
	 */
	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 * @return the buyPrice
	 */
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the mSRP
	 */
	public BigDecimal getMSRP() {
		return MSRP;
	}

	/**
	 * @param mSRP the mSRP to set
	 */
	public void setMSRP(BigDecimal mSRP) {
		MSRP = mSRP;
	}

	/**
	 * @return the productLines
	 */
	public ProductLines getProductLines() {
		return productLines;
	}

	/**
	 * @param productLines the productLines to set
	 */
	public void setProductLines(ProductLines productLines) {
		this.productLines = productLines;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", scale=" + scale + ", vendor=" + vendor + ", description="
				+ description + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP=" + MSRP
				+ ", productLines=" + productLines + "]";
	}

}
