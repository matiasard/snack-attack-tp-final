/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.edu.unju.fi.entity.Office;

/**
 * @author Enzo Sandoval
 *
 */
public interface IOfficeService {

	public List<Office> obtenterOficinas();
	
    public Office buscarOficina(Long id) throws Exception;
	
	public void guardar (Office office);
	
	public Page<Office> findAll(Pageable pagable);
	
	public void borrar(Long id);
	
	public List<Office> buscarOficinasPorPais(String nombreOficina);
	
}
