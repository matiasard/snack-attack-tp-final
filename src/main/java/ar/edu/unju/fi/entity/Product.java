/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "productCode")
	private String id;

	@NotEmpty(message = "The Product Name must not be null nor empty.")
	@Length(max = 70)
	@Column(name = "productName", nullable = false, length = 70)
	private String name;

	@NotBlank(message = "The Product Scale not be null nor must contain  one whitespace character.")
	@Length(max = 10)
	@Column(name = "productScale", nullable = false, length = 10)
	private String scale;

	@NotBlank(message = "The field Product Vendor not be null nor must contain  one whitespace character.")
	@Length(max = 50)
	@Column(name = "productVendor", nullable = false, length = 50)
	private String vendor;

	@NotBlank(message = "The Product Description not be null nor must contain  one whitespace character.")
	@Column(name = "productDescription", nullable = false)
	private String description;

	@NotNull(message = "The Quantity in Stock must not be null")
	@Min(value = 0, message = "Invalid data. The Quantity in Stock must not be a negative number. ")
	@Column(nullable = false)
	private Integer quantityInStock;

	@NotNull(message = "The Buy Price must not be null")
	@Digits(integer = 8, fraction = 2, message = "The Buy Price must be a number whose value must be less than or equal to 99999999.99.")
	@Column(nullable = false)
	private BigDecimal buyPrice;

	@NotNull(message = "The MSRP must not be null")
	@Digits(integer = 8, fraction = 2, message = "The MSRP must be a number whose value must be less than or equal to 99999999.99.")
	@Column(nullable = false)
	private BigDecimal MSRP;

	@Lob
	@Column(name = "image", columnDefinition = "LONGBLOB")
	private String image;

	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productLine")
	private ProductLines productLine;

	@OneToMany(mappedBy = "id.product")
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

	public Product() {
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the productLine
	 */
	public ProductLines getProductLine() {
		return productLine;
	}

	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(ProductLines productLine) {
		this.productLine = productLine;
	}

	/**
	 * @return the orderDetails
	 */
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
