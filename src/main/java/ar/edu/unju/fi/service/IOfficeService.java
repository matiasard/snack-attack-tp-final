/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Office;

/**
 * @author Enzo Sandoval
 *
 */
public interface IOfficeService {

	public List<Office> obtenterOficinas();
	
    public Office buscarOficina(Long id) throws Exception;
	
	public void guardar (Office office);
}
