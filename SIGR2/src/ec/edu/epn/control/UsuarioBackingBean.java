package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.modelo.entity.Reactivo;
import ec.edu.epn.modelo.entity.Usuario;
import ec.edu.epn.modelo.entity.Usuariorol;
import ec.edu.epn.modelo.jpa.JPADAOFactory;


@ManagedBean(name = "usuarioControl")
@SessionScoped
public class UsuarioBackingBean {

	private Usuario usuario;

	public UsuarioBackingBean() {
		new ArrayList<Usuario>();
	}

	public String guardar() {
		JPADAOFactory.getFactory().getUsuarioDAO().create(usuario);
		return "usuario_list";
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdUpdate()));
		setUsuario(JPADAOFactory.getFactory().getUsuarioDAO().read(id));
		return "usuario_update";
	}
	
	public String actualizar(){
		JPADAOFactory.getFactory().getUsuarioDAO().update(usuario);
		return "usuario_list";
	}
	
	public String eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdRemove()));
		JPADAOFactory.getFactory().getUsuarioDAO().deleteByID(id);
		return "usuario_list";
	}

	public List<Usuario> getListUsuario() {
		return JPADAOFactory.getFactory().getUsuarioDAO().findAll();
	}

	public void setListUsuario(List<Usuario> listUsuario) {
	}


	
	
	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return "usuario_new";
	}
	/*Lista de usuarios con el rol de validador*/
	public List<Usuario> getListUsuarioValidador() {
		
		ArrayList<Usuario> listaUsuario=new ArrayList<Usuario>();
		List<Usuariorol> lista=JPADAOFactory.getFactory().getUsuariorolDAO().findAllbyRol("Validador");
		for (Usuariorol usuariorol : lista) {
			listaUsuario.add(usuariorol.getUsuario());
		}
		return listaUsuario;	
		
	}

	public void setListUsuarioValidador(List<Usuario> listUsuario) {
	}

	/*Lista de usuarios con el rol de calibrador*/
	public List<Usuario> getListUsuarioCalibrador() {
		
		ArrayList<Usuario> listaUsuario=new ArrayList<Usuario>();
		List<Usuariorol> lista=JPADAOFactory.getFactory().getUsuariorolDAO().findAllbyRol("Calibrador");
		for (Usuariorol usuariorol : lista) {
			listaUsuario.add(usuariorol.getUsuario());
		}
		return listaUsuario;	
		
	}

	public void setListUsuarioCalibrador(List<Usuario> listUsuario) {
	}

	/*Lista de usuarios con el rol de elaborador*/
	public List<Usuario> getListUsuarioElaborador() {
		
		ArrayList<Usuario> listaUsuario=new ArrayList<Usuario>();
		List<Usuariorol> lista=JPADAOFactory.getFactory().getUsuariorolDAO().findAllbyRol("Elaborador");
		for (Usuariorol usuariorol : lista) {
			listaUsuario.add(usuariorol.getUsuario());
		}
		return listaUsuario;	
		
	}

	public void setListUsuarioElaborador(List<Usuario> listUsuario) {
	}
	/*Funcion para asignar un reactivo al usuario*/
	public String asignarReactivo(){
		/*
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(this.getParameter(context, this.getCmdAsignarReactivo()));
		setUsuario(JPADAOFactory.getFactory().getUsuarioDAO().read(id));
		int id2 = Integer.parseInt(this.getParameter(context, this.getCmdReactivo()));
		*/

		  Map<String,String> params = 
	                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		int id = Integer.parseInt(params.get(this.getCmdAsignarReactivo()));
	  	int id2 = Integer.parseInt(params.get(this.getCmdReactivo()));
		setUsuario(JPADAOFactory.getFactory().getUsuarioDAO().read(id));
		Reactivo reactivo=JPADAOFactory.getFactory().getReactivoDAO().read(id2);
		if(reactivo.getReactivoEstado().equals("Elaborado")){
			reactivo.setReactivoEstado("Validacion");
			Date fechaActual=new Date();
			reactivo.setReactivoFechaAsignacionValidacion(fechaActual);
			reactivo.setUsuario(usuario);
			reactivo.setReactivoEstadoAsignacion("1");
			JPADAOFactory.getFactory().getReactivoDAO().update(reactivo);
		}
		if(reactivo.getReactivoEstado().equals("Validado")){
			reactivo.setReactivoEstado("Calibracion");
			Date fechaActual=new Date();
			reactivo.setReactivoFechaAsignacionCalibracion(fechaActual);
			reactivo.setUsuario(usuario);
			reactivo.setReactivoEstadoAsignacion("1");			
			JPADAOFactory.getFactory().getReactivoDAO().update(reactivo);
		}
		if(reactivo.getReactivoEstado().equals("Elaboracion")){
			reactivo.setUsuario(usuario);
			reactivo.setReactivoEstadoAsignacion("1");			
			JPADAOFactory.getFactory().getReactivoDAO().update(reactivo);
			return "reasignarReactivos";
		}
		return "asignarReactivos";
	}
	public String getCmdAsignarReactivo() {
		return "cmdAsignarReactivo";
	}
	public String getCmdReactivo() {
		return "cmdReactivo";
	}
}