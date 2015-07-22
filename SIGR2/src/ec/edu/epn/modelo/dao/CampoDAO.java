package ec.edu.epn.modelo.dao;

import java.util.List;

import ec.edu.epn.modelo.entity.Campo;

public interface CampoDAO extends GenericDAO<Campo,Integer> {

	public List<Campo> findbyNombre(String nombreCampo);

}
