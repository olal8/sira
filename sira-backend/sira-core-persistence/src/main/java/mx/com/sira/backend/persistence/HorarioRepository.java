package mx.com.sira.backend.persistence;

import mx.com.sira.backend.domain.Horario;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gerry on 10/24/18.
 */
@Repository
@Scope("prototype")
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    @Query("select  h from Horario h where h.estatus=true")
    List<Horario> getHorarios();
}
