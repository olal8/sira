package mx.com.sira.front.dto;

import java.util.Date;

public class UsuarioDto {
	private long id;
	private String nombre;
	private String password;
	private Date fechaRegistro;
	private Date fechaBaja;
	private boolean estado;
	private TipoUsuario tipoUsuario;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", nombre=" + nombre + ", password=" + password + ", fechaRegistro="
				+ fechaRegistro + ", fechaBaja=" + fechaBaja + ", estado=" + estado + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}
	
	
}
