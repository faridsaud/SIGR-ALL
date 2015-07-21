package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TOPICO database table.
 * 
 */
@Entity
@Table(name="TOPICO")
@NamedQuery(name="Topico.findAll", query="SELECT t FROM Topico t")
public class Topico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TOPICO_ID")
	private int topicoId;

	@Column(name="TOPICO_CODIGO")
	private String topicoCodigo;

	@Column(name="TOPICO_ESTADO_BORRADO")
	private int topicoEstadoBorrado;

	@Column(name="TOPICO_NOMBRE")
	private String topicoNombre;

	//bi-directional many-to-one association to Reactivo
	@OneToMany(mappedBy="topico")
	private List<Reactivo> reactivos;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="GRUPO_ID")
	private Grupo grupo;

	public Topico() {
	}

	public int getTopicoId() {
		return this.topicoId;
	}

	public void setTopicoId(int topicoId) {
		this.topicoId = topicoId;
	}

	public String getTopicoCodigo() {
		return this.topicoCodigo;
	}

	public void setTopicoCodigo(String topicoCodigo) {
		this.topicoCodigo = topicoCodigo;
	}

	public int getTopicoEstadoBorrado() {
		return this.topicoEstadoBorrado;
	}

	public void setTopicoEstadoBorrado(int topicoEstadoBorrado) {
		this.topicoEstadoBorrado = topicoEstadoBorrado;
	}

	public String getTopicoNombre() {
		return this.topicoNombre;
	}

	public void setTopicoNombre(String topicoNombre) {
		this.topicoNombre = topicoNombre;
	}

	public List<Reactivo> getReactivos() {
		return this.reactivos;
	}

	public void setReactivos(List<Reactivo> reactivos) {
		this.reactivos = reactivos;
	}

	public Reactivo addReactivo(Reactivo reactivo) {
		getReactivos().add(reactivo);
		reactivo.setTopico(this);

		return reactivo;
	}

	public Reactivo removeReactivo(Reactivo reactivo) {
		getReactivos().remove(reactivo);
		reactivo.setTopico(null);

		return reactivo;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}