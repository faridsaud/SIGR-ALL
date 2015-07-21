package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TAXONOMIABLOOM database table.
 * 
 */
@Entity
@Table(name="TAXONOMIABLOOM")
@NamedQuery(name="Taxonomiabloom.findAll", query="SELECT t FROM Taxonomiabloom t")
public class Taxonomiabloom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TAXONOMIA_ID")
	private int taxonomiaId;

	@Column(name="TAXONOMIA_DESCRIPCION_TAXONOMIA")
	private String taxonomiaDescripcionTaxonomia;

	@Column(name="TAXONOMIA_NOMBRE")
	private String taxonomiaNombre;

	//bi-directional many-to-one association to Reactivo
	@OneToMany(mappedBy="taxonomiabloom")
	private List<Reactivo> reactivos;

	public Taxonomiabloom() {
	}

	public int getTaxonomiaId() {
		return this.taxonomiaId;
	}

	public void setTaxonomiaId(int taxonomiaId) {
		this.taxonomiaId = taxonomiaId;
	}

	public String getTaxonomiaDescripcionTaxonomia() {
		return this.taxonomiaDescripcionTaxonomia;
	}

	public void setTaxonomiaDescripcionTaxonomia(String taxonomiaDescripcionTaxonomia) {
		this.taxonomiaDescripcionTaxonomia = taxonomiaDescripcionTaxonomia;
	}

	public String getTaxonomiaNombre() {
		return this.taxonomiaNombre;
	}

	public void setTaxonomiaNombre(String taxonomiaNombre) {
		this.taxonomiaNombre = taxonomiaNombre;
	}

	public List<Reactivo> getReactivos() {
		return this.reactivos;
	}

	public void setReactivos(List<Reactivo> reactivos) {
		this.reactivos = reactivos;
	}

	public Reactivo addReactivo(Reactivo reactivo) {
		getReactivos().add(reactivo);
		reactivo.setTaxonomiabloom(this);

		return reactivo;
	}

	public Reactivo removeReactivo(Reactivo reactivo) {
		getReactivos().remove(reactivo);
		reactivo.setTaxonomiabloom(null);

		return reactivo;
	}

}