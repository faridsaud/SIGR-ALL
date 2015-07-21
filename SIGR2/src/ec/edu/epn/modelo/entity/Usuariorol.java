package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIOROL database table.
 * 
 */
@Entity
@Table(name="USUARIOROL")
@NamedQuery(name="Usuariorol.findAll", query="SELECT u FROM Usuariorol u")
public class Usuariorol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USUARIOROL_ID")
	private int usuariorolId;

	@Column(name="USUARIOROL_ESTADO")
	private int usuariorolEstado;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL_ID")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	public Usuariorol() {
	}

	public int getUsuariorolId() {
		return this.usuariorolId;
	}

	public void setUsuariorolId(int usuariorolId) {
		this.usuariorolId = usuariorolId;
	}

	public int getUsuariorolEstado() {
		return this.usuariorolEstado;
	}

	public void setUsuariorolEstado(int usuariorolEstado) {
		this.usuariorolEstado = usuariorolEstado;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}