package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Campo;
import ec.edu.epn.modelo.entity.Carrera;
import ec.edu.epn.modelo.entity.Grupo;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "grupoControl")
@SessionScoped
public class GrupoBackingBean {

	private Grupo grupo;

	public GrupoBackingBean() {
		new ArrayList<Grupo>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getGrupoDAO().create(grupo);
		return "grupo_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setGrupo(JPADAOFactory.getFactory().getGrupoDAO().read(id));
		return "grupo_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getGrupoDAO().update(grupo);
		return "grupo_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getGrupoDAO().deleteByID(id);
		return "grupo_list";
	}

	public List<Grupo> getListGrupo() {
		return JPADAOFactory.getFactory().getGrupoDAO().findAll();
	}

	public void setListGrupo(List<Grupo> listGrupo) {
	}

	public Grupo getGrupo() {
		if (grupo == null) {
			grupo = new Grupo();
		}
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getParameter(FacesContext context, String parameter) {
		Map<String, String> map = context.getExternalContext()
				.getRequestParameterMap();
		return map.get(parameter);
	}

	public String getCmdUpdate() {
		return "cmdUpdate";
	}

	public String getCmdRemove() {
		return "cmdRemove";
	}

	public String nuevo() {
		return "grupo_new";
	}
	/*Lista de grupos por campo -Creado por: Farid Saud*/

	public List<Grupo> getListGrupobyCampo(String nombreCampo) {
		List<Campo> listaCampo=JPADAOFactory.getFactory().getCampoDAO().findbyNombre(nombreCampo);
		return listaCampo.get(0).getGrupos();
	}

	public void setListGrupobyCampo(List<Campo> listCampo) {
	}
}