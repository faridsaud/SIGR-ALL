package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RESPUESTA database table.
 * 
 */
@Entity
@Table(name="RESPUESTA")
@NamedQuery(name="Respuesta.findAll", query="SELECT r FROM Respuesta r")
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RESPUESTA_ID")
	private int respuestaId;

	@Column(name="RESPUESTA_ARGUMENTACION")
	private String respuestaArgumentacion;

	@Column(name="RESPUESTA_CORRECTA")
	private int respuestaCorrecta;

	@Column(name="RESPUESTA_OPCION")
	private String respuestaOpcion;

	@Column(name="RESPUESTA_OPCION_IMAGEN")
	private String respuestaOpcionImagen;

	@Column(name="RESPUESTA_SELECCIONAR")
	private String respuestaSeleccionar;

	//bi-directional many-to-one association to Reactivo
	@ManyToOne
	@JoinColumn(name="REACTIVO_ID")
	private Reactivo reactivo;

	public Respuesta() {
	}

	public int getRespuestaId() {
		return this.respuestaId;
	}

	public void setRespuestaId(int respuestaId) {
		this.respuestaId = respuestaId;
	}

	public String getRespuestaArgumentacion() {
		return this.respuestaArgumentacion;
	}

	public void setRespuestaArgumentacion(String respuestaArgumentacion) {
		this.respuestaArgumentacion = respuestaArgumentacion;
	}

	public int getRespuestaCorrecta() {
		return this.respuestaCorrecta;
	}

	public void setRespuestaCorrecta(int respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getRespuestaOpcion() {
		return this.respuestaOpcion;
	}

	public void setRespuestaOpcion(String respuestaOpcion) {
		this.respuestaOpcion = respuestaOpcion;
	}

	public String getRespuestaOpcionImagen() {
		return this.respuestaOpcionImagen;
	}

	public void setRespuestaOpcionImagen(String respuestaOpcionImagen) {
		this.respuestaOpcionImagen = respuestaOpcionImagen;
	}

	public String getRespuestaSeleccionar() {
		return this.respuestaSeleccionar;
	}

	public void setRespuestaSeleccionar(String respuestaSeleccionar) {
		this.respuestaSeleccionar = respuestaSeleccionar;
	}

	public Reactivo getReactivo() {
		return this.reactivo;
	}

	public void setReactivo(Reactivo reactivo) {
		this.reactivo = reactivo;
	}

}