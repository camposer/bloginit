package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQueries({
		@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
		@NamedQuery(name="Usuario.findByNombre", 
		query="SELECT u FROM Usuario u WHERE u.nombre LIKE :param")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=20)
	private String clave;

	@Column(length=50)
	private String nombre;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", clave=" + clave + ", nombre=" + nombre
				+ "]";
	}
}