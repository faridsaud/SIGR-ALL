package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Reactivo;
import ec.edu.epn.modelo.entity.Carrera;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "reactivoCompletamientoControl")
@SessionScoped
public class ReactivoCompletamientoBackingBean {

	private Reactivo reactivo;

	public ReactivoCompletamientoBackingBean() {
		new ArrayList<Reactivo>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getReactivoDAO().create(reactivo);
		return "reactivo_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setReactivo(JPADAOFactory.getFactory().getReactivoDAO().read(id));
		return "reactivo_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getReactivoDAO().update(reactivo);
		return "reactivo_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getReactivoDAO().deleteByID(id);
		return "reactivo_list";
	}

	public List<Reactivo> getListReactivo() {
		return JPADAOFactory.getFactory().getReactivoDAO().findAll();
	}

	public void setListReactivo(List<Reactivo> listReactivo) {
	}

	public Reactivo getReactivo() {
		if (reactivo == null) {
			reactivo = new Reactivo();
		}
		return reactivo;
	}
	
	public void setReactivo(Reactivo reactivo) {
		this.reactivo = reactivo;
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
		return "reactivo_new";
	}

	/*Lista de reactivos por tipo y estado - Creado por Farid Saud*/
	public List<Reactivo> getListReactivoHomeElaboradorReactivoCompletamiento() {

		return JPADAOFactory.getFactory().getReactivoDAO().findByTipoAndByEstado("Elaboracion", "Completamiento");
	}

	public void getListListReactivoHomeElaboradorReactivoCompletamiento(List<Reactivo> listReactivo) {
	}	
}