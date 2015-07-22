package ec.edu.epn.modelo.dao;

import java.util.List;

import ec.edu.epn.modelo.entity.Carrera;

public interface CarreraDAO extends GenericDAO<Carrera,Integer> {

	public List<Carrera> findbyNombre(String nombreCarrera);
}
