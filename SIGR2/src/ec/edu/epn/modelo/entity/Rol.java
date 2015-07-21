package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name="ROL")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROL_ID")
	private int rolId;

	@Column(name="ROL_ESTADO_BORRADO")
	private int rolEstadoBorrado;

	@Column(name="ROL_NOMBRE")
	private String rolNombre;

	//bi-directional many-to-one association to Rolpermiso
	@OneToMany(mappedBy="rol")
	private List<Rolpermiso> rolpermisos;

	//bi-directional many-to-one association to Usuariorol
	@OneToMany(mappedBy="rol")
	private List<Usuariorol> usuariorols;

	public Rol() {
	}

	public int getRolId() {
		return this.rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public int getRolEstadoBorrado() {
		return this.rolEstadoBorrado;
	}

	public void setRolEstadoBorrado(int rolEstadoBorrado) {
		this.rolEstadoBorrado = rolEstadoBorrado;
	}

	public String getRolNombre() {
		return this.rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public List<Rolpermiso> getRolpermisos() {
		return this.rolpermisos;
	}

	public void setRolpermisos(List<Rolpermiso> rolpermisos) {
		this.rolpermisos = rolpermisos;
	}

	public Rolpermiso addRolpermiso(Rolpermiso rolpermiso) {
		getRolpermisos().add(rolpermiso);
		rolpermiso.setRol(this);

		return rolpermiso;
	}

	public Rolpermiso removeRolpermiso(Rolpermiso rolpermiso) {
		getRolpermisos().remove(rolpermiso);
		rolpermiso.setRol(null);

		return rolpermiso;
	}

	public List<Usuariorol> getUsuariorols() {
		return this.usuariorols;
	}

	public void setUsuariorols(List<Usuariorol> usuariorols) {
		this.usuariorols = usuariorols;
	}

	public Usuariorol addUsuariorol(Usuariorol usuariorol) {
		getUsuariorols().add(usuariorol);
		usuariorol.setRol(this);

		return usuariorol;
	}

	public Usuariorol removeUsuariorol(Usuariorol usuariorol) {
		getUsuariorols().remove(usuariorol);
		usuariorol.setRol(null);

		return usuariorol;
	}

}