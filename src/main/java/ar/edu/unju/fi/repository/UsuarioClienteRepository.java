/**
 * 
 */
package ar.edu.unju.fi.repository;

import javax.transaction.Transactional;

import ar.edu.unju.fi.entity.UsuarioCliente;

/**
 * @author Enzo Sandoval
 *
 */
@Transactional
public interface UsuarioClienteRepository extends UsuarioRepositoryGeneric<UsuarioCliente> {

}
