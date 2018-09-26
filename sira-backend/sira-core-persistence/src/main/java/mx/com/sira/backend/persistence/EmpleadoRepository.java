package mx.com.sira.backend.persistence;

import mx.com.sira.backend.domain.Empleado;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gerry on 26/09/18.
 */
@Repository
@Scope("prototype")
public interface EmpleadoRepository extends JpaRepository<Empleado,Long>{
}
