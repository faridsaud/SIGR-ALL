package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIOCARRERA database table.
 * 
 */
@Entity
@Table(name="USUARIOCARRERA")
@NamedQuery(name="Usuariocarrera.findAll", query="SELECT u FROM Usuariocarrera u")
public class Usuariocarrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USUAIOCARRERA_ID")
	private int usuaiocarreraId;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="CARRERA_ID")
	private Carrera carrera;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	public Usuariocarrera() {
	}

	public int getUsuaiocarreraId() {
		return this.usuaiocarreraId;
	}

	public void setUsuaiocarreraId(int usuaiocarreraId) {
		this.usuaiocarreraId = usuaiocarreraId;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}