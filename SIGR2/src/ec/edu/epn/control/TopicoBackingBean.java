package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Topico;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "topicoControl")
@SessionScoped
public class TopicoBackingBean {

	private Topico topico;

	public TopicoBackingBean() {
		new ArrayList<Topico>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getTopicoDAO().create(topico);
		return "topico_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setTopico(JPADAOFactory.getFactory().getTopicoDAO().read(id));
		return "topico_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getTopicoDAO().update(topico);
		return "topico_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getTopicoDAO().deleteByID(id);
		return "topico_list";
	}

	public List<Topico> getListTopico() {
		return JPADAOFactory.getFactory().getTopicoDAO().findAll();
	}

	public void setListTopico(List<Topico> listTopico) {
	}

	public Topico getTopico() {
		if (topico == null) {
			topico = new Topico();
		}
		return topico;
	}
	
	public void setTopico(Topico topico) {
		this.topico = topico;
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
		return "topico_new";
	}
}