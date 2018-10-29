package mx.com.sira.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gerry on 10/28/18.
 */
@Entity
@Table(name = "giro")
public class Giro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgiro")
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
