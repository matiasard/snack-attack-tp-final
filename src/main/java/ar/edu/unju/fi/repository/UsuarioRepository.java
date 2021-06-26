package ar.edu.unju.fi.repository;

import javax.transaction.Transactional;

import ar.edu.unju.fi.entity.Usuario;

@Transactional
public interface UsuarioRepository extends UsuarioRepositoryGeneric<Usuario> {

}
