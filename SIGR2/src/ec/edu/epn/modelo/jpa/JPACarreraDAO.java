package ec.edu.epn.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ec.edu.epn.modelo.dao.CarreraDAO;
import ec.edu.epn.modelo.entity.Carrera;

public class JPACarreraDAO extends JPAGenericDAO<Carrera, Integer>
implements CarreraDAO {

public JPACarreraDAO() {
super(Carrera.class);
// TODO Auto-generated constructor stub

}
@SuppressWarnings("unchecked")
@Override
public List<Carrera> findbyNombre(String nombreCarrera) {
	try {
		Query query = em.createNamedQuery("Carrera.findbyNombre");
		query.setParameter("nombreCarrera", nombreCarrera);
		return query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
		return new ArrayList<Carrera>();
	}
}
}

