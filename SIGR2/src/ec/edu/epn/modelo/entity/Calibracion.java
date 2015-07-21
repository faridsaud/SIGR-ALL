package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CALIBRACION database table.
 * 
 */
@Entity
@Table(name="CALIBRACION")
@NamedQuery(name="Calibracion.findAll", query="SELECT c FROM Calibracion c")
public class Calibracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CALIBRACION_ID")
	private int calibracionId;

	@Column(name="CALIBRACION_COMENTARIO")
	private String calibracionComentario;

	@Column(name="CALIBRACION_ESTADO")
	private int calibracionEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="CALIBRACION_FECHA")
	private Date calibracionFecha;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	//bi-directional many-to-one association to Reactivo
	@OneToMany(mappedBy="calibracion")
	private List<Reactivo> reactivos;

	public Calibracion() {
	}

	public int getCalibracionId() {
		return this.calibracionId;
	}

	public void setCalibracionId(int calibracionId) {
		this.calibracionId = calibracionId;
	}

	public String getCalibracionComentario() {
		return this.calibracionComentario;
	}

	public void setCalibracionComentario(String calibracionComentario) {
		this.calibracionComentario = calibracionComentario;
	}

	public int getCalibracionEstado() {
		return this.calibracionEstado;
	}

	public void setCalibracionEstado(int calibracionEstado) {
		this.calibracionEstado = calibracionEstado;
	}

	public Date getCalibracionFecha() {
		return this.calibracionFecha;
	}

	public void setCalibracionFecha(Date calibracionFecha) {
		this.calibracionFecha = calibracionFecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Reactivo> getReactivos() {
		return this.reactivos;
	}

	public void setReactivos(List<Reactivo> reactivos) {
		this.reactivos = reactivos;
	}

	public Reactivo addReactivo(Reactivo reactivo) {
		getReactivos().add(reactivo);
		reactivo.setCalibracion(this);

		return reactivo;
	}

	public Reactivo removeReactivo(Reactivo reactivo) {
		getReactivos().remove(reactivo);
		reactivo.setCalibracion(null);

		return reactivo;
	}

}