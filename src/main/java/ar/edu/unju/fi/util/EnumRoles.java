/**
 * 
 */
package ar.edu.unju.fi.util;

/**
 * @author Enzo Sandoval
 *
 */
public enum EnumRoles {

	ROL_VENDEDOR("ROLE_USER"),
	ROL_ADMINISTRADOR("ROLE_ADMIN");

	private final String descripcion;

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	private EnumRoles(String descripcion) {
		this.descripcion = descripcion;
	}

}
