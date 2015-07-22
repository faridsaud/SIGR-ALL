package ec.edu.epn.modelo.dao;

import java.util.List;


import ec.edu.epn.modelo.entity.Topico;

public interface TopicoDAO extends GenericDAO<Topico,Integer> {

	public List<Topico> findbyNombre(String nombreGrupo);

}
