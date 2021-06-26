/**
 * 
 */
package ar.edu.unju.fi.repository;

import javax.transaction.Transactional;

import ar.edu.unju.fi.entity.UsuarioEmpleado;

/**
 * @author Enzo Sandoval
 *
 */
@Transactional
public interface UsuarioEmpleadoRepository extends UsuarioRepositoryGeneric<UsuarioEmpleado> {

}
