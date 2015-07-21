package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ROLPERMISOS database table.
 * 
 */
@Entity
@Table(name="ROLPERMISOS")
@NamedQuery(name="Rolpermiso.findAll", query="SELECT r FROM Rolpermiso r")
public class Rolpermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLPERMISOS_ID")
	private int rolpermisosId;

	//bi-directional many-to-one association to Permiso
	@ManyToOne
	@JoinColumn(name="PERMISO_ID")
	private Permiso permiso;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL_ID")
	private Rol rol;

	public Rolpermiso() {
	}

	public int getRolpermisosId() {
		return this.rolpermisosId;
	}

	public void setRolpermisosId(int rolpermisosId) {
		this.rolpermisosId = rolpermisosId;
	}

	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}