/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

/**
 * @author Enzo Sandoval
 *
 */
@Entity
@Component
@Table(name = "productlines")
public class ProductLines {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Length(max = 50)
	@Column(name = "productLine")
	private String productLine;

	@NotEmpty
	@Length(max = 4000)
	@Column
	private String textDescription;

	@Column
	private String htmlDescription;

	@Lob
	@Column(name = "image", columnDefinition = "LONGBLOB")
	private String image;

	@OneToMany(mappedBy = "productLine")
	private List<Product> productos = new ArrayList<Product>();

	public ProductLines() {
	}

	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
	}

	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	/**
	 * @return the textDescription
	 */
	public String getTextDescription() {
		return textDescription;
	}

	/**
	 * @param textDescription the textDescription to set
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	/**
	 * @return the htmlDescription
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}

	/**
	 * @param htmlDescription the htmlDescription to set
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
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
	 * @return the productos
	 */
	public List<Product> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "ProductLines [productLine=" + productLine + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", image=" + image + ", productos=" + productos + "]";
	}

}
