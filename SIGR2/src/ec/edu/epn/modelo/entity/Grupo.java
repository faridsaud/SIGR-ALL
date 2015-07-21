package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GRUPO database table.
 * 
 */
@Entity
@Table(name="GRUPO")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GRUPO_ID")
	private int grupoId;

	@Column(name="GRUPO_CODIGO")
	private String grupoCodigo;

	@Column(name="GRUPO_ESTADO_BORRADO")
	private int grupoEstadoBorrado;

	@Column(name="GRUPO_NOMBRE")
	private String grupoNombre;

	//bi-directional many-to-one association to Campo
	@ManyToOne
	@JoinColumn(name="CAMPO_ID")
	private Campo campo;

	//bi-directional many-to-one association to Topico
	@OneToMany(mappedBy="grupo")
	private List<Topico> topicos;

	public Grupo() {
	}

	public int getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public String getGrupoCodigo() {
		return this.grupoCodigo;
	}

	public void setGrupoCodigo(String grupoCodigo) {
		this.grupoCodigo = grupoCodigo;
	}

	public int getGrupoEstadoBorrado() {
		return this.grupoEstadoBorrado;
	}

	public void setGrupoEstadoBorrado(int grupoEstadoBorrado) {
		this.grupoEstadoBorrado = grupoEstadoBorrado;
	}

	public String getGrupoNombre() {
		return this.grupoNombre;
	}

	public void setGrupoNombre(String grupoNombre) {
		this.grupoNombre = grupoNombre;
	}

	public Campo getCampo() {
		return this.campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public List<Topico> getTopicos() {
		return this.topicos;
	}

	public void setTopicos(List<Topico> topicos) {
		this.topicos = topicos;
	}

	public Topico addTopico(Topico topico) {
		getTopicos().add(topico);
		topico.setGrupo(this);

		return topico;
	}

	public Topico removeTopico(Topico topico) {
		getTopicos().remove(topico);
		topico.setGrupo(null);

		return topico;
	}

}