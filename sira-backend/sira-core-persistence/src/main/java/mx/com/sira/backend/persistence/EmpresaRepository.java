package mx.com.sira.backend.persistence;

import mx.com.sira.backend.domain.Empresa;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gerry on 10/28/18.
 */
@Scope("prototype")
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
