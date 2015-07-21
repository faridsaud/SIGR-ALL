package ec.edu.epn.modelo.dao;

import java.util.List;

import ec.edu.epn.modelo.entity.Usuariorol;

public interface UsuariorolDAO extends GenericDAO<Usuariorol,Integer> {
	
	public List<Usuariorol>findAllbyRol(String estado);


}
