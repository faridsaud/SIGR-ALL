 package ec.edu.epn.modelo.jpa;

import ec.edu.epn.modelo.dao.CampoDAO;
import ec.edu.epn.modelo.dao.CarreraDAO;
import ec.edu.epn.modelo.dao.DAOFactory;
import ec.edu.epn.modelo.dao.GrupoDAO;
import ec.edu.epn.modelo.dao.ReactivoDAO;
import ec.edu.epn.modelo.dao.RolDAO;
import ec.edu.epn.modelo.dao.TopicoDAO;
import ec.edu.epn.modelo.dao.UsuarioDAO;
import ec.edu.epn.modelo.dao.UsuariorolDAO;


public class JPADAOFactory extends DAOFactory {


	
	@Override
	public CampoDAO getCampoDAO() {
		// TODO Auto-generated method stub
		return new JPACampoDAO();
	}


	@Override
	public ReactivoDAO getReactivoDAO() {
		// TODO Auto-generated method stub
		return new JPAReactivoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}
	
	@Override
	public UsuariorolDAO getUsuariorolDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuariorolDAO();
	}
	
	@Override
	public RolDAO getRolDAO() {
		// TODO Auto-generated method stub
		return new JPARolDAO();
	}
	
	@Override
	public CarreraDAO getCarreraDAO() {
		// TODO Auto-generated method stub
		return new JPACarreraDAO();
	}
	
	@Override
	public GrupoDAO getGrupoDAO() {
		// TODO Auto-generated method stub
		return new JPAGrupoDAO();
	}
	
	@Override
	public TopicoDAO getTopicoDAO() {
		// TODO Auto-generated method stub
		return new JPATopicoDAO();
	}
}
