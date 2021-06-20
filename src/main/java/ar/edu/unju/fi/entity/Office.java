/**
 * 
 */
package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "offices")
public class Office {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Length(max = 10)
	@Column(name = "officeCode", unique = true, nullable = false, updatable = false)
	private Long code;

	@NotBlank
	@Length(max = 50)
	@Column(nullable = false, length = 50)
	private String phone;

	@NotBlank
	@Length(max = 50)
	@Column(name = "addressLine1", nullable = false, length = 50)
	private String addressLine1;

	@NotBlank
	@Length(max = 50)
	@Column(name = "addressLine2", nullable = false, length = 50)
	private String addressLine2;

	@NotBlank
	@Length(max = 50)
	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@NotBlank
	@Length(max = 50)
	@Column(name = "country", nullable = false, length = 50)
	private String country;
	
	@NotBlank
	@Length(max = 50)
	@Column(name = "state", nullable = false, length = 50)
	private String state;

	@NotBlank
	@Length(max = 50)
	@Column(name = "postalCode", nullable = false, length = 50)
	private String postalCode;

	@NotBlank
	@Length(max = 50)
	@Column(name = "territory", nullable = false, length = 50)
	private String territory;

	public Office() {
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the territory
	 */
	public String getTerritory() {
		return territory;
	}

	/**
	 * @param territory the territory to set
	 */
	public void setTerritory(String territory) {
		this.territory = territory;
	}

	@Override
	public String toString() {
		return "Office [code=" + code + ", phone=" + phone + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", territory="
				+ territory + "]";
	}

}
