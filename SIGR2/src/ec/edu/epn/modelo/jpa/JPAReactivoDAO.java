package ec.edu.epn.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ec.edu.epn.modelo.dao.ReactivoDAO;
import ec.edu.epn.modelo.entity.Reactivo;

public class JPAReactivoDAO extends JPAGenericDAO<Reactivo, Integer> implements
		ReactivoDAO {

	public JPAReactivoDAO() {
		super(Reactivo.class);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reactivo> findAllbyEstado(String estadoReactivo) {
		try {
			Query query = em.createNamedQuery("Reactivo.findAllbyEstado");
			query.setParameter("estadoReactivo", estadoReactivo);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Reactivo>();
		}
	}
}
