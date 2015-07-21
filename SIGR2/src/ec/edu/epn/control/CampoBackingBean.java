package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Campo;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "campoControl")
@SessionScoped
public class CampoBackingBean {

	private Campo campo;

	public CampoBackingBean() {
		new ArrayList<Campo>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getCampoDAO().create(campo);
		return "campo_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setCampo(JPADAOFactory.getFactory().getCampoDAO().read(id));
		return "campo_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getCampoDAO().update(campo);
		return "campo_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getCampoDAO().deleteByID(id);
		return "campo_list";
	}

	public List<Campo> getListCampo() {
		return JPADAOFactory.getFactory().getCampoDAO().findAll();
	}

	public void setListCampo(List<Campo> listCampo) {
	}

	public Campo getCampo() {
		if (campo == null) {
			campo = new Campo();
		}
		return campo;
	}
	
	public void setCampo(Campo campo) {
		this.campo = campo;
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
		return "campo_new";
	}
}