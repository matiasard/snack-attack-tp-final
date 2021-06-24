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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

	@NotEmpty(message="The Phone Number must not be null nor empty.")
	@Length(min=6, max = 50, message="The Phone Number must be at least six characters.")
	@Column(nullable = false, length = 50)
	private String phone;

	@NotEmpty(message="The Address Line 1 must not be null nor empty.")
	@Length(min=4, max = 50, message="The Address Line 1 must be at least four characters.")
	@Column(name = "addressLine1", nullable = false, length = 50)
	private String addressLine1;

	@Length(max = 50)
	@Column(name = "addressLine2", nullable = false, length = 50)
	private String addressLine2;

	@NotEmpty(message="The field City must not be null nor empty.")
	@Length(min=2, max = 50, message="The field City must be at least two characters.")
	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@NotEmpty(message="The field Country must not be null nor empty.")
	@Length(min=2, max = 50, message="The field Country must be at least two characters.")
	@Column(name = "country", nullable = false, length = 50)
	private String country;
	
	@Length(min=2, max = 50, message="The field Country can have at least two characters .")
	@Column(name = "state", nullable = false, length = 50)
	private String state;

	@NotEmpty(message="The Postal Code must not be null nor empty.")
	@Length(min=2, max = 15, message="The field Postal Code must be between two and fifteen characters only ")
	@Column(name = "postalCode", nullable = false, length = 15)
	private String postalCode;

	@NotEmpty(message="The field Territory must not be null nor empty.")
	@Length(min=2, max = 10, message="The field Territory must be between two and ten characters only ")
	@Column(name = "territory", nullable = false, length = 10)
	private String territory;
	
	@NotEmpty(message = "Must enter the name of the office ")
	@Size(min = 6, message = "Please enter a Office Name of at least 6 characters ")
	@Column(name = "officeName")
	private String nombre;

	@NotEmpty(message = "You must enter latitude value")
	@Size(max = 128, message = "Latitude value exceeded")
	@Column(name = "officeLatitude")
	private String latitud;

	@NotEmpty(message = "You must enter Longitude value")
	@Size(max = 128, message = "Longitude value exceeded")
	@Column(name = "officeLongitude")
	private String longitud;

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

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Office [code=" + code + ", phone=" + phone + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", country=" + country + ", state=" + state + ", postalCode="
				+ postalCode + ", territory=" + territory + ", nombre=" + nombre + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]";
	}
	
	


}
