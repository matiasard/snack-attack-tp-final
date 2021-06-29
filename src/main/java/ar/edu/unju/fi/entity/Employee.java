/**
 * 
 */
package ar.edu.unju.fi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Enzo Sandoval
 *
 */
@Entity
@Component
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeNumber", unique = true, nullable = false, updatable = false)
	private Long number;

	@NotBlank(message = "The field First Name must not be null nor must contain  one whitespace character.")
	@Length(min = 2, max = 50, message = "Employee First Name must be at least two characters.")
	@Column(nullable = false, length = 50)
	private String firstName;

	@NotEmpty(message = "The field Last Name must not be null nor empty.")
	@Length(min = 1, max = 50, message = "Employee First Name must be at least one character.")
	@Column(nullable = false, length = 50)
	private String lastName;

	@NotBlank(message = "The field Extension must not be null nor must contain  one whitespace character.")
	@Length(max = 10)
	@Column(nullable = false, length = 10)
	private String extension;

	@Email(message = "Invalid email format ")
	@NotBlank(message = "You must enter an email address ")
	@Length(max = 100)
	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@NotEmpty(message = "The Job Title must not be null nor empty.")
	@Length(max = 50)
	@Column(nullable = false, length = 50)
	private String jobTitle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reportsTo")
	private Employee reportsTo;

	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "officeCode")
	private Office office;

	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userNumber")
	private UsuarioEmpleado usuarioEmpleado;

	public Employee() {
	}

	/**
	 * @return the number
	 */
	public Long getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Long number) {
		this.number = number;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the reportsTo
	 */
	public Employee getReportsTo() {
		return reportsTo;
	}

	/**
	 * @param reportsTo the reportsTo to set
	 */
	public void setReportsTo(Employee reportsTo) {
		this.reportsTo = reportsTo;
	}

	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return the usuarioEmpleado
	 */
	public UsuarioEmpleado getUsuarioEmpleado() {
		return usuarioEmpleado;
	}

	/**
	 * @param usuarioEmpleado the usuarioEmpleado to set
	 */
	public void setUsuarioEmpleado(UsuarioEmpleado usuarioEmpleado) {
		this.usuarioEmpleado = usuarioEmpleado;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", firstName=" + firstName + ", lastName=" + lastName + ", extension="
				+ extension + ", email=" + email + ", jobTitle=" + jobTitle + ", reportsTo=" + reportsTo + ", office="
				+ office + ", usuarioEmpleado=" + usuarioEmpleado + "]";
	}

}
