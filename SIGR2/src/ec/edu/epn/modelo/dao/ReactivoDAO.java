package ec.edu.epn.modelo.dao;

import java.util.List;

import ec.edu.epn.modelo.entity.Reactivo;
public interface ReactivoDAO extends GenericDAO<Reactivo,Integer> {

	public List<Reactivo> findAllbyEstado(String estadoReactivo);

}
