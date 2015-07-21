package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Usuariorol;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "usuariorolControl")
@SessionScoped
public class UsuariorolBackingBean {

	private Usuariorol usuariorol;

	public UsuariorolBackingBean() {
		new ArrayList<Usuariorol>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getUsuariorolDAO().create(usuariorol);
		return "usuariorol_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setUsuariorol(JPADAOFactory.getFactory().getUsuariorolDAO().read(id));
		return "usuariorol_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getUsuariorolDAO().update(usuariorol);
		return "usuariorol_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getUsuariorolDAO().deleteByID(id);
		return "usuariorol_list";
	}

	public List<Usuariorol> getListUsuariorol() {
		return JPADAOFactory.getFactory().getUsuariorolDAO().findAll();
	}

	public void setListUsuariorol(List<Usuariorol> listUsuariorol) {
	}

	public Usuariorol getUsuariorol() {
		if (usuariorol == null) {
			usuariorol = new Usuariorol();
		}
		return usuariorol;
	}
	
	public void setUsuariorol(Usuariorol usuariorol) {
		this.usuariorol = usuariorol;
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
		return "usuariorol_new";
	}
}