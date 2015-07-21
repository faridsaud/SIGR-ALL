package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRUEBAREACTIVO database table.
 * 
 */
@Entity
@Table(name="PRUEBAREACTIVO")
@NamedQuery(name="Pruebareactivo.findAll", query="SELECT p FROM Pruebareactivo p")
public class Pruebareactivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRUEBAREACTIVO_ID")
	private int pruebareactivoId;

	//bi-directional many-to-one association to Prueba
	@ManyToOne
	@JoinColumn(name="PRUEBA_ID")
	private Prueba prueba;

	//bi-directional many-to-one association to Reactivo
	@ManyToOne
	@JoinColumn(name="REACTIVO_ID")
	private Reactivo reactivo;

	public Pruebareactivo() {
	}

	public int getPruebareactivoId() {
		return this.pruebareactivoId;
	}

	public void setPruebareactivoId(int pruebareactivoId) {
		this.pruebareactivoId = pruebareactivoId;
	}

	public Prueba getPrueba() {
		return this.prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

	public Reactivo getReactivo() {
		return this.reactivo;
	}

	public void setReactivo(Reactivo reactivo) {
		this.reactivo = reactivo;
	}

}