package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the REACTIVO database table.
 * 
 */
@Entity
@Table(name="REACTIVO")
@NamedQueries({
	@NamedQuery(name="Reactivo.findAll", query="SELECT r FROM Reactivo r"),
	@NamedQuery(name="Reactivo.findAllbyEstado", query="SELECT r FROM Reactivo r WHERE r.reactivoEstado=:estadoReactivo")
})
public class Reactivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REACTIVO_ID")
	private int reactivoId;

	@Column(name="REACTIVO_ELABORADO_POR")
	private String reactivoElaboradoPor;

	@Column(name="REACTIVO_ESTADO")
	private String reactivoEstado;

	@Column(name="REACTIVO_ESTADO_ASIGNACION")
	private String reactivoEstadoAsignacion;

	@Column(name="REACTIVO_ESTADO_BORRADO")
	private int reactivoEstadoBorrado;

	@Temporal(TemporalType.DATE)
	@Column(name="REACTIVO_FECHA_ASIGNACION_CALIBRACION")
	private Date reactivoFechaAsignacionCalibracion;

	@Temporal(TemporalType.DATE)
	@Column(name="REACTIVO_FECHA_ASIGNACION_VALIDACION")
	private Date reactivoFechaAsignacionValidacion;

	@Temporal(TemporalType.DATE)
	@Column(name="REACTIVO_FECHA_MODIFICACION")
	private Date reactivoFechaModificacion;

	@Column(name="REACTIVO_INSTRUCCION")
	private String reactivoInstruccion;

	@Column(name="REACTIVO_RESPUESTA_CORRECTA")
	private int reactivoRespuestaCorrecta;

	@Column(name="REACTIVO_TIPO")
	private String reactivoTipo;

	//bi-directional many-to-one association to Pruebareactivo
	@OneToMany(mappedBy="reactivo")
	private List<Pruebareactivo> pruebareactivos;

	//bi-directional many-to-one association to Calibracion
	@ManyToOne
	@JoinColumn(name="CALIBRACION_ID")
	private Calibracion calibracion;

	//bi-directional many-to-one association to Reactivo
	@ManyToOne
	@JoinColumn(name="REA_REACTIVO_ID")
	private Reactivo reactivo;

	//bi-directional many-to-one association to Reactivo
	@OneToMany(mappedBy="reactivo")
	private List<Reactivo> reactivos;

	//bi-directional many-to-one association to Taxonomiabloom
	@ManyToOne
	@JoinColumn(name="TAXONOMIA_ID")
	private Taxonomiabloom taxonomiabloom;

	//bi-directional many-to-one association to Topico
	@ManyToOne
	@JoinColumn(name="TOPICO_ID")
	private Topico topico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	//bi-directional many-to-one association to Validacion
	@ManyToOne
	@JoinColumn(name="VALIDACION_ID")
	private Validacion validacion;

	//bi-directional many-to-one association to Reactivorespuesta
	@OneToMany(mappedBy="reactivo")
	private List<Reactivorespuesta> reactivorespuestas;

	public Reactivo() {
	}

	public int getReactivoId() {
		return this.reactivoId;
	}

	public void setReactivoId(int reactivoId) {
		this.reactivoId = reactivoId;
	}

	public String getReactivoElaboradoPor() {
		return this.reactivoElaboradoPor;
	}

	public void setReactivoElaboradoPor(String reactivoElaboradoPor) {
		this.reactivoElaboradoPor = reactivoElaboradoPor;
	}

	public String getReactivoEstado() {
		return this.reactivoEstado;
	}

	public void setReactivoEstado(String reactivoEstado) {
		this.reactivoEstado = reactivoEstado;
	}

	public String getReactivoEstadoAsignacion() {
		return this.reactivoEstadoAsignacion;
	}

	public void setReactivoEstadoAsignacion(String reactivoEstadoAsignacion) {
		this.reactivoEstadoAsignacion = reactivoEstadoAsignacion;
	}

	public int getReactivoEstadoBorrado() {
		return this.reactivoEstadoBorrado;
	}

	public void setReactivoEstadoBorrado(int reactivoEstadoBorrado) {
		this.reactivoEstadoBorrado = reactivoEstadoBorrado;
	}

	public Date getReactivoFechaAsignacionCalibracion() {
		return this.reactivoFechaAsignacionCalibracion;
	}

	public void setReactivoFechaAsignacionCalibracion(Date reactivoFechaAsignacionCalibracion) {
		this.reactivoFechaAsignacionCalibracion = reactivoFechaAsignacionCalibracion;
	}

	public Date getReactivoFechaAsignacionValidacion() {
		return this.reactivoFechaAsignacionValidacion;
	}

	public void setReactivoFechaAsignacionValidacion(Date reactivoFechaAsignacionValidacion) {
		this.reactivoFechaAsignacionValidacion = reactivoFechaAsignacionValidacion;
	}

	public Date getReactivoFechaModificacion() {
		return this.reactivoFechaModificacion;
	}

	public void setReactivoFechaModificacion(Date reactivoFechaModificacion) {
		this.reactivoFechaModificacion = reactivoFechaModificacion;
	}

	public String getReactivoInstruccion() {
		return this.reactivoInstruccion;
	}

	public void setReactivoInstruccion(String reactivoInstruccion) {
		this.reactivoInstruccion = reactivoInstruccion;
	}

	public int getReactivoRespuestaCorrecta() {
		return this.reactivoRespuestaCorrecta;
	}

	public void setReactivoRespuestaCorrecta(int reactivoRespuestaCorrecta) {
		this.reactivoRespuestaCorrecta = reactivoRespuestaCorrecta;
	}

	public String getReactivoTipo() {
		return this.reactivoTipo;
	}

	public void setReactivoTipo(String reactivoTipo) {
		this.reactivoTipo = reactivoTipo;
	}

	public List<Pruebareactivo> getPruebareactivos() {
		return this.pruebareactivos;
	}

	public void setPruebareactivos(List<Pruebareactivo> pruebareactivos) {
		this.pruebareactivos = pruebareactivos;
	}

	public Pruebareactivo addPruebareactivo(Pruebareactivo pruebareactivo) {
		getPruebareactivos().add(pruebareactivo);
		pruebareactivo.setReactivo(this);

		return pruebareactivo;
	}

	public Pruebareactivo removePruebareactivo(Pruebareactivo pruebareactivo) {
		getPruebareactivos().remove(pruebareactivo);
		pruebareactivo.setReactivo(null);

		return pruebareactivo;
	}

	public Calibracion getCalibracion() {
		return this.calibracion;
	}

	public void setCalibracion(Calibracion calibracion) {
		this.calibracion = calibracion;
	}

	public Reactivo getReactivo() {
		return this.reactivo;
	}

	public void setReactivo(Reactivo reactivo) {
		this.reactivo = reactivo;
	}

	public List<Reactivo> getReactivos() {
		return this.reactivos;
	}

	public void setReactivos(List<Reactivo> reactivos) {
		this.reactivos = reactivos;
	}

	public Reactivo addReactivo(Reactivo reactivo) {
		getReactivos().add(reactivo);
		reactivo.setReactivo(this);

		return reactivo;
	}

	public Reactivo removeReactivo(Reactivo reactivo) {
		getReactivos().remove(reactivo);
		reactivo.setReactivo(null);

		return reactivo;
	}

	public Taxonomiabloom getTaxonomiabloom() {
		return this.taxonomiabloom;
	}

	public void setTaxonomiabloom(Taxonomiabloom taxonomiabloom) {
		this.taxonomiabloom = taxonomiabloom;
	}

	public Topico getTopico() {
		return this.topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Validacion getValidacion() {
		return this.validacion;
	}

	public void setValidacion(Validacion validacion) {
		this.validacion = validacion;
	}

	public List<Reactivorespuesta> getReactivorespuestas() {
		return this.reactivorespuestas;
	}

	public void setReactivorespuestas(List<Reactivorespuesta> reactivorespuestas) {
		this.reactivorespuestas = reactivorespuestas;
	}

	public Reactivorespuesta addReactivorespuesta(Reactivorespuesta reactivorespuesta) {
		getReactivorespuestas().add(reactivorespuesta);
		reactivorespuesta.setReactivo(this);

		return reactivorespuesta;
	}

	public Reactivorespuesta removeReactivorespuesta(Reactivorespuesta reactivorespuesta) {
		getReactivorespuestas().remove(reactivorespuesta);
		reactivorespuesta.setReactivo(null);

		return reactivorespuesta;
	}

}