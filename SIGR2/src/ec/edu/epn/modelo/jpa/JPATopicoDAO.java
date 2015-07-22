package ec.edu.epn.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ec.edu.epn.modelo.dao.TopicoDAO;
import ec.edu.epn.modelo.entity.Topico;

public class JPATopicoDAO extends JPAGenericDAO<Topico, Integer>
implements TopicoDAO {

public JPATopicoDAO() {
super(Topico.class);
// TODO Auto-generated constructor stub
}
@SuppressWarnings("unchecked")
@Override
public List<Topico> findbyNombre(String nombreGrupo) {
	try {
		Query query = em.createNamedQuery("Topico.findbyNombre");
		query.setParameter("nombreGrupo", nombreGrupo);
		return query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
		return new ArrayList<Topico>();
	}
}
}
