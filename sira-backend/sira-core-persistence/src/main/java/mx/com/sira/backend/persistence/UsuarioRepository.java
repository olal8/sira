package mx.com.sira.backend.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.sira.backend.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
