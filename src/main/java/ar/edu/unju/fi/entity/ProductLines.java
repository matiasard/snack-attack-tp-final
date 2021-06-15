/**
 * 
 */
package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Length(max = 50)
	@Column(unique = true, nullable = false, updatable = false)
	private String productLine;

	@NotBlank
	@Length(max = 4000)
	@Column(nullable = false, length = 4000)
	private String textDescription;

	@Column
	private String htmlDescription;

	@Lob
	@Column(name = "image", columnDefinition = "MEDIUMBLOB")
	private String image;

	public ProductLines() {
	}

	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
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

	@Override
	public String toString() {
		return "ProductLines [productLine=" + productLine + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", image=" + image + "]";
	}

}
