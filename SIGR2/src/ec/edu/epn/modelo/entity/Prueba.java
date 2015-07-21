package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRUEBAS database table.
 * 
 */
@Entity
@Table(name="PRUEBAS")
@NamedQuery(name="Prueba.findAll", query="SELECT p FROM Prueba p")
public class Prueba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRUEBA_ID")
	private int pruebaId;

	@Column(name="PRUEBA_CODIGO")
	private String pruebaCodigo;

	@Column(name="PRUEBA_ESTADO_BORRADO")
	private int pruebaEstadoBorrado;

	@Column(name="PRUEBA_NUM_ITEMS")
	private int pruebaNumItems;

	//bi-directional many-to-one association to Pruebareactivo
	@OneToMany(mappedBy="prueba")
	private List<Pruebareactivo> pruebareactivos;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="CARRERA_ID")
	private Carrera carrera;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	public Prueba() {
	}

	public int getPruebaId() {
		return this.pruebaId;
	}

	public void setPruebaId(int pruebaId) {
		this.pruebaId = pruebaId;
	}

	public String getPruebaCodigo() {
		return this.pruebaCodigo;
	}

	public void setPruebaCodigo(String pruebaCodigo) {
		this.pruebaCodigo = pruebaCodigo;
	}

	public int getPruebaEstadoBorrado() {
		return this.pruebaEstadoBorrado;
	}

	public void setPruebaEstadoBorrado(int pruebaEstadoBorrado) {
		this.pruebaEstadoBorrado = pruebaEstadoBorrado;
	}

	public int getPruebaNumItems() {
		return this.pruebaNumItems;
	}

	public void setPruebaNumItems(int pruebaNumItems) {
		this.pruebaNumItems = pruebaNumItems;
	}

	public List<Pruebareactivo> getPruebareactivos() {
		return this.pruebareactivos;
	}

	public void setPruebareactivos(List<Pruebareactivo> pruebareactivos) {
		this.pruebareactivos = pruebareactivos;
	}

	public Pruebareactivo addPruebareactivo(Pruebareactivo pruebareactivo) {
		getPruebareactivos().add(pruebareactivo);
		pruebareactivo.setPrueba(this);

		return pruebareactivo;
	}

	public Pruebareactivo removePruebareactivo(Pruebareactivo pruebareactivo) {
		getPruebareactivos().remove(pruebareactivo);
		pruebareactivo.setPrueba(null);

		return pruebareactivo;
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