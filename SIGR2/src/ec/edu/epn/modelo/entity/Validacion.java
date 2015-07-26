package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the VALIDACION database table.
 * 
 */
@Entity
@Table(name="VALIDACION")
@NamedQuery(name="Validacion.findAll", query="SELECT v FROM Validacion v")
public class Validacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VALIDACION_ID")
	private int validacionId;

	@Column(name="VALIDACION_COMENTARIO")
	private String validacionComentario;

	@Column(name="VALIDACION_ESTADO")
	private int validacionEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDACION_FECHA")
	private Date validacionFecha;

	//bi-directional many-to-one association to Lineamiento
	@OneToMany(mappedBy="validacion")
	private List<Lineamiento> lineamientos;

	//bi-directional many-to-one association to Reactivo
	@OneToMany(mappedBy="validacion")
	private List<Reactivo> reactivos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	public Validacion() {
	}

	public int getValidacionId() {
		return this.validacionId;
	}

	public void setValidacionId(int validacionId) {
		this.validacionId = validacionId;
	}

	public String getValidacionComentario() {
		return this.validacionComentario;
	}

	public void setValidacionComentario(String validacionComentario) {
		this.validacionComentario = validacionComentario;
	}

	public int getValidacionEstado() {
		return this.validacionEstado;
	}

	public void setValidacionEstado(int validacionEstado) {
		this.validacionEstado = validacionEstado;
	}

	public Date getValidacionFecha() {
		return this.validacionFecha;
	}

	public void setValidacionFecha(Date validacionFecha) {
		this.validacionFecha = validacionFecha;
	}

	public List<Lineamiento> getLineamientos() {
		return this.lineamientos;
	}

	public void setLineamientos(List<Lineamiento> lineamientos) {
		this.lineamientos = lineamientos;
	}

	public Lineamiento addLineamiento(Lineamiento lineamiento) {
		getLineamientos().add(lineamiento);
		lineamiento.setValidacion(this);

		return lineamiento;
	}

	public Lineamiento removeLineamiento(Lineamiento lineamiento) {
		getLineamientos().remove(lineamiento);
		lineamiento.setValidacion(null);

		return lineamiento;
	}

	public List<Reactivo> getReactivos() {
		return this.reactivos;
	}

	public void setReactivos(List<Reactivo> reactivos) {
		this.reactivos = reactivos;
	}

	public Reactivo addReactivo(Reactivo reactivo) {
		getReactivos().add(reactivo);
		reactivo.setValidacion(this);

		return reactivo;
	}

	public Reactivo removeReactivo(Reactivo reactivo) {
		getReactivos().remove(reactivo);
		reactivo.setValidacion(null);

		return reactivo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}