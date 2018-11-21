package mx.com.sira.backend.persistence;

import mx.com.sira.backend.domain.Giro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gerry on 11/21/18.
 */
public interface GiroRepository extends JpaRepository<Giro,Long> {
}
