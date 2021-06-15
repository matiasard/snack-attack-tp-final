/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Length(max = 11)
	@Column(name = "customerNumber", unique = true, nullable = false, updatable = false)
	private Long number;

	@NotBlank
	@Length(max = 50)
	@Column(name = "customerName", nullable = false, length = 50)
	private String name;

	@NotBlank
	@Length(max = 50)
	@Column(nullable = false, length = 50)
	private String contactFirstName;

	@NotBlank
	@Length(max = 50)
	@Column(nullable = false, length = 50)
	private String contactLastName;

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
	@Column(name = "state", nullable = false, length = 50)
	private String state;

	@NotBlank
	@Length(max = 50)
	@Column(name = "postalCode", nullable = false, length = 50)
	private String postalCode;

	@NotBlank
	@Length(max = 50)
	@Column(name = "country", nullable = false, length = 50)
	private String country;

	@NotBlank
	@Length(max = 50)
	@Column(nullable = false, length = 50)
	private BigDecimal creditLimit;

	@ManyToOne
	@JoinColumn(name = "salesRepEmployeeNumber")
	private Employee salesRepresentative;

	public Customer() {
	}

	/**
	 * @return the number
	 */
	public Long getNumber() {
		return number;
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
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}

	/**
	 * @param contactFirstName the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * @param contactLastName the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
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
	 * @return the creditLimit
	 */
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 * @return the salesRepresentative
	 */
	public Employee getSalesRepresentative() {
		return salesRepresentative;
	}

	/**
	 * @param salesRepresentative the salesRepresentative to set
	 */
	public void setSalesRepresentative(Employee salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	@Override
	public String toString() {
		return "Customer [number=" + number + ", name=" + name + ", contactFirstName=" + contactFirstName
				+ ", contactLastName=" + contactLastName + ", phone=" + phone + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", country=" + country + ", creditLimit=" + creditLimit + ", salesRepresentative="
				+ salesRepresentative +  "]";
	}

}
