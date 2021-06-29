/**
 * 
 */
package ar.edu.unju.fi.util;

/**
 * @author Enzo Sandoval
 *
 */
public enum EnumRoles {

	ROL_CLIENTE("CLIENTE"),
	ROL_VENDEDOR("VENDEDOR");

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
