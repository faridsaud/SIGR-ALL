package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LINEAMIENTO database table.
 * 
 */
@Entity
@Table(name="LINEAMIENTO")
@NamedQuery(name="Lineamiento.findAll", query="SELECT l FROM Lineamiento l")
public class Lineamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LINEAMIENTO_ID")
	private int lineamientoId;

	@Column(name="LINEAMIENTO_DEFINICION")
	private String lineamientoDefinicion;

	@Column(name="LINEAMIENTO_ESPECIFICACION")
	private String lineamientoEspecificacion;

	@Column(name="LINEAMIENTO_ESTADO")
	private int lineamientoEstado;

	//bi-directional many-to-one association to Validacion
	@ManyToOne
	@JoinColumn(name="VALIDACION_ID")
	private Validacion validacion;

	public Lineamiento() {
	}

	public int getLineamientoId() {
		return this.lineamientoId;
	}

	public void setLineamientoId(int lineamientoId) {
		this.lineamientoId = lineamientoId;
	}

	public String getLineamientoDefinicion() {
		return this.lineamientoDefinicion;
	}

	public void setLineamientoDefinicion(String lineamientoDefinicion) {
		this.lineamientoDefinicion = lineamientoDefinicion;
	}

	public String getLineamientoEspecificacion() {
		return this.lineamientoEspecificacion;
	}

	public void setLineamientoEspecificacion(String lineamientoEspecificacion) {
		this.lineamientoEspecificacion = lineamientoEspecificacion;
	}

	public int getLineamientoEstado() {
		return this.lineamientoEstado;
	}

	public void setLineamientoEstado(int lineamientoEstado) {
		this.lineamientoEstado = lineamientoEstado;
	}

	public Validacion getValidacion() {
		return this.validacion;
	}

	public void setValidacion(Validacion validacion) {
		this.validacion = validacion;
	}

}