package ec.edu.epn.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ec.edu.epn.modelo.dao.GrupoDAO;
import ec.edu.epn.modelo.entity.Grupo;

public class JPAGrupoDAO extends JPAGenericDAO<Grupo, Integer>
implements GrupoDAO {

public JPAGrupoDAO() {
super(Grupo.class);
// TODO Auto-generated constructor stub
}
@SuppressWarnings("unchecked")
@Override
public List<Grupo> findbyNombre(String nombreCampo) {
	try {
		Query query = em.createNamedQuery("Grupo.findbyNombre");
		query.setParameter("nombreCampo", nombreCampo);
		return query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
		return new ArrayList<Grupo>();
	}
}
}
