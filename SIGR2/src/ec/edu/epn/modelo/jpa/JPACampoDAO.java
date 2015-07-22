package ec.edu.epn.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ec.edu.epn.modelo.dao.CampoDAO;
import ec.edu.epn.modelo.entity.Campo;

public class JPACampoDAO extends JPAGenericDAO<Campo, Integer>
implements CampoDAO {

public JPACampoDAO() {
super(Campo.class);
// TODO Auto-generated constructor stub
}
@SuppressWarnings("unchecked")
@Override
public List<Campo> findbyNombre(String nombreCarrera) {
	try {
		Query query = em.createNamedQuery("Campo.findbyNombre");
		query.setParameter("nombreCarrera", nombreCarrera);
		return query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
		return new ArrayList<Campo>();
	}
}
}
