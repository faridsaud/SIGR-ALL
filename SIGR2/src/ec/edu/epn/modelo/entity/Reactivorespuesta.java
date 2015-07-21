package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REACTIVORESPUESTAS database table.
 * 
 */
@Entity
@Table(name="REACTIVORESPUESTAS")
@NamedQuery(name="Reactivorespuesta.findAll", query="SELECT r FROM Reactivorespuesta r")
public class Reactivorespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REACTIVORESPUESTAS_ID")
	private int reactivorespuestasId;

	//bi-directional many-to-one association to Reactivo
	@ManyToOne
	@JoinColumn(name="REACTIVO_ID")
	private Reactivo reactivo;

	//bi-directional many-to-one association to Respuesta
	@ManyToOne
	@JoinColumn(name="RESPUESTA_ID")
	private Respuesta respuesta;

	public Reactivorespuesta() {
	}

	public int getReactivorespuestasId() {
		return this.reactivorespuestasId;
	}

	public void setReactivorespuestasId(int reactivorespuestasId) {
		this.reactivorespuestasId = reactivorespuestasId;
	}

	public Reactivo getReactivo() {
		return this.reactivo;
	}

	public void setReactivo(Reactivo reactivo) {
		this.reactivo = reactivo;
	}

	public Respuesta getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

}