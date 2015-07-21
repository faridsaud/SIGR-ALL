package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CAMPO database table.
 * 
 */
@Entity
@Table(name="CAMPO")
@NamedQuery(name="Campo.findAll", query="SELECT c FROM Campo c")
public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMPO_ID")
	private int campoId;

	@Column(name="CAMPO_CODIGO")
	private String campoCodigo;

	@Column(name="CAMPO_ESTADO_BORRADO")
	private int campoEstadoBorrado;

	@Column(name="CAMPO_NOMBRE")
	private String campoNombre;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="CARRERA_ID")
	private Carrera carrera;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="campo")
	private List<Grupo> grupos;

	public Campo() {
	}

	public int getCampoId() {
		return this.campoId;
	}

	public void setCampoId(int campoId) {
		this.campoId = campoId;
	}

	public String getCampoCodigo() {
		return this.campoCodigo;
	}

	public void setCampoCodigo(String campoCodigo) {
		this.campoCodigo = campoCodigo;
	}

	public int getCampoEstadoBorrado() {
		return this.campoEstadoBorrado;
	}

	public void setCampoEstadoBorrado(int campoEstadoBorrado) {
		this.campoEstadoBorrado = campoEstadoBorrado;
	}

	public String getCampoNombre() {
		return this.campoNombre;
	}

	public void setCampoNombre(String campoNombre) {
		this.campoNombre = campoNombre;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setCampo(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setCampo(null);

		return grupo;
	}

}