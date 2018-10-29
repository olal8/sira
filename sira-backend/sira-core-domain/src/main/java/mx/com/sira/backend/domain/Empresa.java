package mx.com.sira.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by gerry on 10/28/18.
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa")
    private Long idEmpresa;
    @Column(name = "denominacion")
    private String denominacion;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idgiro", nullable = false)
    private Giro giro;
    @Column(name = "calle")
    private String calle;
    @Column(name = "num_ext")
    private String num_ext;
    @Column(name = "num_int")
    private String num_int;
    @Column(name = "colonia")
    private String colonia;
    @Column(name = "cp")
    private String cp;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "coordenada_x")
    private String coordenada_x;
    @Column(name = "coordenada_y")
    private String coordenada_y;
    @Column(name = "fecha_registro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
    private Date fechaRegistro;

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Giro getGiro() {
        return giro;
    }

    public void setGiro(Giro giro) {
        this.giro = giro;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNum_ext() {
        return num_ext;
    }

    public void setNum_ext(String num_ext) {
        this.num_ext = num_ext;
    }

    public String getNum_int() {
        return num_int;
    }

    public void setNum_int(String num_int) {
        this.num_int = num_int;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(String coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public String getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(String coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
