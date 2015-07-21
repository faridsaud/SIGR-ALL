package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VALIDACIONLINEAMIENTO database table.
 * 
 */
@Entity
@Table(name="VALIDACIONLINEAMIENTO")
@NamedQuery(name="Validacionlineamiento.findAll", query="SELECT v FROM Validacionlineamiento v")
public class Validacionlineamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VALIDACIONLINEAMIENTO_ID")
	private int validacionlineamientoId;

	//bi-directional many-to-one association to Lineamiento
	@ManyToOne
	@JoinColumn(name="LINEAMIENTO_ID")
	private Lineamiento lineamiento;

	//bi-directional many-to-one association to Validacion
	@ManyToOne
	@JoinColumn(name="VALIDACION_ID")
	private Validacion validacion;

	public Validacionlineamiento() {
	}

	public int getValidacionlineamientoId() {
		return this.validacionlineamientoId;
	}

	public void setValidacionlineamientoId(int validacionlineamientoId) {
		this.validacionlineamientoId = validacionlineamientoId;
	}

	public Lineamiento getLineamiento() {
		return this.lineamiento;
	}

	public void setLineamiento(Lineamiento lineamiento) {
		this.lineamiento = lineamiento;
	}

	public Validacion getValidacion() {
		return this.validacion;
	}

	public void setValidacion(Validacion validacion) {
		this.validacion = validacion;
	}

}