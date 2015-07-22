package ec.edu.epn.modelo.dao;

import java.util.List;


import ec.edu.epn.modelo.entity.Grupo;

public interface GrupoDAO extends GenericDAO<Grupo,Integer> {

	public List<Grupo> findbyNombre(String nombreCampo);

}
