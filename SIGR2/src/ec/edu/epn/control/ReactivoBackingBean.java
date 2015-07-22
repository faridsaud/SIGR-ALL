package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Reactivo;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "reactivoControl")
@SessionScoped
public class ReactivoBackingBean {

	private Reactivo reactivo;
	/*Variable temporal usada para filtrar reactivos por este topico -Creado por: Farid Saud*/
	private String topico;
	/*Variable temporal usada para tener la lista de reactivos*/
	private List<Reactivo> listaAuxiliarReactivosPorAsignar=JPADAOFactory.getFactory().getReactivoDAO().findReactivosPorAsignar();
	
	public ReactivoBackingBean() {
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

	/*Listas de reactivos con estado de Elaborado -Modificacion realizada por Farid Saud*/
	public List<Reactivo> getListReactivoElaborado() {
		return JPADAOFactory.getFactory().getReactivoDAO().findAllbyEstado("Elaborado");
	}

	public void setListReactivoElaborado(List<Reactivo> listReactivo) {
	}
	/*Listas de reactivos con estado de Verificado -Modificacion realizada por Farid Saud*/
	public List<Reactivo> getListReactivoVerificado() {

		return JPADAOFactory.getFactory().getReactivoDAO().findAllbyEstado("Verificado");
	}

	public void setListReactivoVerificado(List<Reactivo> listReactivo) {
	}	
	/*Lista de reactivos por asignar-Modificacion realizada por Farid Saud*/
	public List<Reactivo> getListReactivoPorAsignar() {

		return JPADAOFactory.getFactory().getReactivoDAO().findReactivosPorAsignar();
	}

	public void setListReactivoPorAsignar(List<Reactivo> listReactivo) {
	}	

	/*Lista de reactivos por reasignar-Modificacion realizada por Farid Saud*/
	public List<Reactivo> getListReactivoPorReasignar() {

		return JPADAOFactory.getFactory().getReactivoDAO().findReactivosPorReasignar();
	}

	public void setListReactivoPorReasignar(List<Reactivo> listReactivo) {
	}	
	/*Funcion de asignacion de reactivos -Modificacion realizada por Farid Saud*/	
	public String asignar(){
		
		Map<String,String> params = 
	                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		  int id = Integer.parseInt(params.get(this.getCmdAsignar()));
		/*
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdAsignar()));
		*/
		setReactivo(JPADAOFactory.getFactory().getReactivoDAO().read(id));
	
		if(reactivo.getReactivoEstado().equals("Elaborado")){
			return "asignarReactivosElaborado?faces-redirect=true";
		}
		if(reactivo.getReactivoEstado().equals("Validado")){
			return "asignarReactivosValidado?faces-redirect=true";
		}
		if(reactivo.getReactivoEstado().equals("Elaboracion")){
			return "reasignarReactivosElaboracion?faces-redirect=true";
		}
		
		return "asignarReactivos?faces-redirect=true";
	}
	public String getCmdAsignar() {
		return "cmdAsignar";
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}
	
	/*Lista de reactivos por reasignar con topico como parametro de busqueda-Modificacion realizada por Farid Saud*/
	public void changeListAuxiliarReactivoOnTopicoChange() {

		setListaAuxiliarReactivosPorAsignar(JPADAOFactory.getFactory().getReactivoDAO().findReactivosPorAsignarByTopico(topico));
	}
	
	public List<Reactivo> getListaAuxiliarReactivosPorAsignar() {
		return listaAuxiliarReactivosPorAsignar;
	}

	public void setListaAuxiliarReactivosPorAsignar(List<Reactivo> listaAuxiliarReactivos) {
		this.listaAuxiliarReactivosPorAsignar = listaAuxiliarReactivos;
	}

	
	

}