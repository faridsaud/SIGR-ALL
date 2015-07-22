package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Carrera;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "carreraControl")
@SessionScoped
public class CarreraBackingBean {

	private Carrera carrera;

	public CarreraBackingBean() {
		new ArrayList<Carrera>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getCarreraDAO().create(carrera);
		return "carrera_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setCarrera(JPADAOFactory.getFactory().getCarreraDAO().read(id));
		return "carrera_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getCarreraDAO().update(carrera);
		return "carrera_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getCarreraDAO().deleteByID(id);
		return "carrera_list";
	}

	public List<Carrera> getListCarrera() {
		return JPADAOFactory.getFactory().getCarreraDAO().findAll();
	}

	public void setListCarrera(List<Carrera> listCarrera) {
	}

	public Carrera getCarrera() {
		if (carrera == null) {
			carrera = new Carrera();
		}
		return carrera;
	}
	
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
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
		return "carrera_new";
	}
}