package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Rol;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "rolControl")
@SessionScoped
public class RolBackingBean {

	private Rol rol;

	public RolBackingBean() {
		new ArrayList<Rol>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getRolDAO().create(rol);
		return "rol_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setRol(JPADAOFactory.getFactory().getRolDAO().read(id));
		return "rol_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getRolDAO().update(rol);
		return "rol_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getRolDAO().deleteByID(id);
		return "rol_list";
	}

	public List<Rol> getListRol() {
		return JPADAOFactory.getFactory().getRolDAO().findAll();
	}

	public void setListRol(List<Rol> listRol) {
	}

	public Rol getRol() {
		if (rol == null) {
			rol = new Rol();
		}
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
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
		return "rol_new";
	}
}