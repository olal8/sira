package mx.com.sira.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 806422934184416372L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtipo_usuario")
	private long idTipo;
	@Column(name="descripcion",nullable=false)
	private String descripcion;

	public long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoUsuario [idTipo=" + idTipo + ", descripcion=" + descripcion + "]";
	}

}