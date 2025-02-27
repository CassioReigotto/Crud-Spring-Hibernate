package br.com.cassio.crudspringhibernate.repository;

import br.com.cassio.crudspringhibernate.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
