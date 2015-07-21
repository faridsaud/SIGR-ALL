package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CARRERA database table.
 * 
 */
@Entity
@Table(name="CARRERA")
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARRERA_ID")
	private int carreraId;

	@Column(name="CARRERA_CODIGO")
	private String carreraCodigo;

	@Column(name="CARRERA_ESTADO_BORRADO")
	private int carreraEstadoBorrado;

	@Column(name="CARRERA_NOMBRE")
	private String carreraNombre;

	@Column(name="CARRERA_TIPO")
	private String carreraTipo;

	//bi-directional many-to-one association to Campo
	@OneToMany(mappedBy="carrera")
	private List<Campo> campos;

	//bi-directional many-to-one association to Prueba
	@OneToMany(mappedBy="carrera")
	private List<Prueba> pruebas;

	//bi-directional many-to-one association to Usuariocarrera
	@OneToMany(mappedBy="carrera")
	private List<Usuariocarrera> usuariocarreras;

	public Carrera() {
	}

	public int getCarreraId() {
		return this.carreraId;
	}

	public void setCarreraId(int carreraId) {
		this.carreraId = carreraId;
	}

	public String getCarreraCodigo() {
		return this.carreraCodigo;
	}

	public void setCarreraCodigo(String carreraCodigo) {
		this.carreraCodigo = carreraCodigo;
	}

	public int getCarreraEstadoBorrado() {
		return this.carreraEstadoBorrado;
	}

	public void setCarreraEstadoBorrado(int carreraEstadoBorrado) {
		this.carreraEstadoBorrado = carreraEstadoBorrado;
	}

	public String getCarreraNombre() {
		return this.carreraNombre;
	}

	public void setCarreraNombre(String carreraNombre) {
		this.carreraNombre = carreraNombre;
	}

	public String getCarreraTipo() {
		return this.carreraTipo;
	}

	public void setCarreraTipo(String carreraTipo) {
		this.carreraTipo = carreraTipo;
	}

	public List<Campo> getCampos() {
		return this.campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	public Campo addCampo(Campo campo) {
		getCampos().add(campo);
		campo.setCarrera(this);

		return campo;
	}

	public Campo removeCampo(Campo campo) {
		getCampos().remove(campo);
		campo.setCarrera(null);

		return campo;
	}

	public List<Prueba> getPruebas() {
		return this.pruebas;
	}

	public void setPruebas(List<Prueba> pruebas) {
		this.pruebas = pruebas;
	}

	public Prueba addPrueba(Prueba prueba) {
		getPruebas().add(prueba);
		prueba.setCarrera(this);

		return prueba;
	}

	public Prueba removePrueba(Prueba prueba) {
		getPruebas().remove(prueba);
		prueba.setCarrera(null);

		return prueba;
	}

	public List<Usuariocarrera> getUsuariocarreras() {
		return this.usuariocarreras;
	}

	public void setUsuariocarreras(List<Usuariocarrera> usuariocarreras) {
		this.usuariocarreras = usuariocarreras;
	}

	public Usuariocarrera addUsuariocarrera(Usuariocarrera usuariocarrera) {
		getUsuariocarreras().add(usuariocarrera);
		usuariocarrera.setCarrera(this);

		return usuariocarrera;
	}

	public Usuariocarrera removeUsuariocarrera(Usuariocarrera usuariocarrera) {
		getUsuariocarreras().remove(usuariocarrera);
		usuariocarrera.setCarrera(null);

		return usuariocarrera;
	}

}