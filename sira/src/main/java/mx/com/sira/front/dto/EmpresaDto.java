package mx.com.sira.front.dto;

import java.util.Date;

/**
 * Created by gerry on 10/30/18.
 */
public class EmpresaDto {
    private Long idEmpresa;
    private String denominacion;
    private GiroDto giro;
    private String calle;
    private String num_ext;
    private String num_int;
    private String colonia;
    private String cp;
    private String telefono;
    private String coordenada_x;
    private String coordenada_y;
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

    public GiroDto getGiro() {
        return giro;
    }

    public void setGiro(GiroDto giro) {
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

    @Override
    public String toString() {
        return "EmpresaDto{" +
                "idEmpresa=" + idEmpresa +
                ", denominacion='" + denominacion + '\'' +
                ", giro=" + giro +
                ", calle='" + calle + '\'' +
                ", num_ext='" + num_ext + '\'' +
                ", num_int='" + num_int + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp='" + cp + '\'' +
                ", telefono='" + telefono + '\'' +
                ", coordenada_x='" + coordenada_x + '\'' +
                ", coordenada_y='" + coordenada_y + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
