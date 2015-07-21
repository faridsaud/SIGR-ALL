package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PERMISOS database table.
 * 
 */
@Entity
@Table(name="PERMISOS")
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERMISO_ID")
	private int permisoId;

	@Column(name="PERMISO_ESTADO")
	private int permisoEstado;

	@Column(name="PERMISO_NOMBRE")
	private String permisoNombre;

	//bi-directional many-to-one association to Rolpermiso
	@OneToMany(mappedBy="permiso")
	private List<Rolpermiso> rolpermisos;

	public Permiso() {
	}

	public int getPermisoId() {
		return this.permisoId;
	}

	public void setPermisoId(int permisoId) {
		this.permisoId = permisoId;
	}

	public int getPermisoEstado() {
		return this.permisoEstado;
	}

	public void setPermisoEstado(int permisoEstado) {
		this.permisoEstado = permisoEstado;
	}

	public String getPermisoNombre() {
		return this.permisoNombre;
	}

	public void setPermisoNombre(String permisoNombre) {
		this.permisoNombre = permisoNombre;
	}

	public List<Rolpermiso> getRolpermisos() {
		return this.rolpermisos;
	}

	public void setRolpermisos(List<Rolpermiso> rolpermisos) {
		this.rolpermisos = rolpermisos;
	}

	public Rolpermiso addRolpermiso(Rolpermiso rolpermiso) {
		getRolpermisos().add(rolpermiso);
		rolpermiso.setPermiso(this);

		return rolpermiso;
	}

	public Rolpermiso removeRolpermiso(Rolpermiso rolpermiso) {
		getRolpermisos().remove(rolpermiso);
		rolpermiso.setPermiso(null);

		return rolpermiso;
	}

}