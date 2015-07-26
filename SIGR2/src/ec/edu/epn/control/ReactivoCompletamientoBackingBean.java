package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.*;
import javax.faces.application.*;

import ec.edu.epn.modelo.entity.Campo;
import ec.edu.epn.modelo.entity.Grupo;
import ec.edu.epn.modelo.entity.Reactivo;
import ec.edu.epn.modelo.entity.Carrera;
import ec.edu.epn.modelo.entity.Topico;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "reactivoCompletamientoControl")
@SessionScoped
public class ReactivoCompletamientoBackingBean {

	private Reactivo reactivo;
	private String campo;
	private String topico;
	private String grupo;
	private String carrera;
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

	public String getCmdModificar() {
		return "cmdModificar";
	}
	public String getCmdValidar() {
		return "cmdModificar";
	}
	public String getCmdCalibrar() {
		return "cmdModificar";
	}
	public String nuevo() {
		return "reactivo_new";
	}

	/*Lista de reactivos por tipo y estado - Creado por Farid Saud*/
	public List<Reactivo> getListReactivoHomeElaboradorReactivoCompletamiento() {

		return JPADAOFactory.getFactory().getReactivoDAO().findByTipoAndByEstado("Elaboracion", "Completamiento");
	}

	public void setListReactivoHomeElaboradorReactivoCompletamiento(List<Reactivo> listReactivo) {
	}
	
	public List<Reactivo> getListReactivoHomeValidadorReactivoCompletamiento() {

		return JPADAOFactory.getFactory().getReactivoDAO().findByTipoAndByEstado("Validacion", "Completamiento");
	}

	public void setListReactivoHomeValidadorReactivoCompletamiento(List<Reactivo> listReactivo) {
	}
	
	public List<Reactivo> getListReactivoHomeCalibradorReactivoCompletamiento() {

		return JPADAOFactory.getFactory().getReactivoDAO().findByTipoAndByEstado("Calibracion", "Completamiento");
	}

	public void setListReactivoHomeCalibradorReactivoCompletamiento(List<Reactivo> listReactivo) {
	}


	public void onCarreraChange() {
		this.listaCampos = JPADAOFactory.getFactory().getCampoDAO()
				.findbyNombre(this.carrera);
	}
	
	public void onCampoChange() {
		this.listaGrupos = JPADAOFactory.getFactory().getGrupoDAO()
				.findbyNombre(this.campo);
	}

	public void onGrupoChange() {
		this.listaTopicos = JPADAOFactory.getFactory().getTopicoDAO()
				.findbyNombre(this.grupo);
	}
	
	public void cargarImagen(ActionEvent actionEvent) {
		
        addMessage("Imagen Cargada!!!");
    }
	
	public void accionPreview(ActionEvent actionEvent) {
		
        addMessage("");
    }
	
	public void accionGuardar(ActionEvent actionEvent) {
		
        addMessage("");
    }

	public void accionCancelar(ActionEvent actionEvent) {
	
    addMessage("");
 }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}
