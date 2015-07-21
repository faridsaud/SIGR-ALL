package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Validacionlineamiento
	@OneToMany(mappedBy="lineamiento")
	private List<Validacionlineamiento> validacionlineamientos;

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

	public List<Validacionlineamiento> getValidacionlineamientos() {
		return this.validacionlineamientos;
	}

	public void setValidacionlineamientos(List<Validacionlineamiento> validacionlineamientos) {
		this.validacionlineamientos = validacionlineamientos;
	}

	public Validacionlineamiento addValidacionlineamiento(Validacionlineamiento validacionlineamiento) {
		getValidacionlineamientos().add(validacionlineamiento);
		validacionlineamiento.setLineamiento(this);

		return validacionlineamiento;
	}

	public Validacionlineamiento removeValidacionlineamiento(Validacionlineamiento validacionlineamiento) {
		getValidacionlineamientos().remove(validacionlineamiento);
		validacionlineamiento.setLineamiento(null);

		return validacionlineamiento;
	}

}