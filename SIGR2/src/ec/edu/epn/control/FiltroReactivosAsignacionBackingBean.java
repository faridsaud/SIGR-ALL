package ec.edu.epn.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.epn.modelo.entity.Campo;
import ec.edu.epn.modelo.entity.Carrera;
import ec.edu.epn.modelo.entity.Grupo;
import ec.edu.epn.modelo.entity.Reactivo;
import ec.edu.epn.modelo.entity.Topico;
import ec.edu.epn.modelo.jpa.JPADAOFactory;

@ManagedBean(name = "asignacionFiltradoControl")
@SessionScoped
public class FiltroReactivosAsignacionBackingBean {
	private String campo;
	private String carrera;
	private String topico;
	private String grupo;
	private List<Carrera> listaCarreras = JPADAOFactory.getFactory()
			.getCarreraDAO().findAll();
	private List<Campo> listaCampos;
	private List<Topico> listaTopicos;
	private List<Grupo> listaGrupos;
	
	public List<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	public void setListaCarreras(List<Carrera> listaCarerra) {
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<Campo> getListaCampos() {
		return listaCampos;
	}

	public void setListaCampos(List<Campo> listaCampos) {
		this.listaCampos = listaCampos;
	}

	public List<Topico> getListaTopicos() {
		return listaTopicos;
	}

	public void setListaTopicos(List<Topico> listaTopicos) {
		this.listaTopicos = listaTopicos;
	}

	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public void onCarreraChange() {
		this.listaCampos = JPADAOFactory.getFactory().getCampoDAO()
				.findbyNombre(this.carrera);
		//System.out.println("--------------------> " + carrera);
		
	}

	public void onCampoChange() {
		this.listaGrupos = JPADAOFactory.getFactory().getGrupoDAO()
				.findbyNombre(this.campo);
	}

	public void onGrupoChange() {
		this.listaTopicos = JPADAOFactory.getFactory().getTopicoDAO()
				.findbyNombre(this.grupo);
	}
}
