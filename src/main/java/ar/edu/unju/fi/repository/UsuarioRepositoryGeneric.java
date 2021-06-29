/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ar.edu.unju.fi.entity.Usuario;

/**
 * @author Enzo Sandoval
 *
 */
@NoRepositoryBean
public interface UsuarioRepositoryGeneric<T extends Usuario> extends JpaRepository<T, Long> {

	T findByUsernameAndPassword(String username, String password);

	T findByUsername(String username);

}
