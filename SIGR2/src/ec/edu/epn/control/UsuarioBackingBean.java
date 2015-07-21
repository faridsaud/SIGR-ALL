package ec.edu.epn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	/*Lista de usuarios con el rol de verificador*/
	public List<Usuario> getListUsuarioVerificador() {
		
		ArrayList<Usuario> listaUsuario=new ArrayList<Usuario>();
		List<Usuariorol> lista=JPADAOFactory.getFactory().getUsuariorolDAO().findAllbyRol("Verificador");
		for (Usuariorol usuariorol : lista) {
			listaUsuario.add(usuariorol.getUsuario());
		}
		return listaUsuario;	
		
	}

	public void setListUsuarioVerificador(List<Usuario> listUsuario) {
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
}