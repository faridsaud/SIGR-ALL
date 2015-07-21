package ec.edu.epn.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ec.edu.epn.modelo.dao.UsuariorolDAO;
import ec.edu.epn.modelo.entity.Usuariorol;

public class JPAUsuariorolDAO extends JPAGenericDAO<Usuariorol, Integer>
		implements UsuariorolDAO {

	public JPAUsuariorolDAO() {
		super(Usuariorol.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuariorol> findAllbyRol(String estado) {
		try {
			Query query = em.createNamedQuery("Usuariorol.findAllbyRol");
			query.setParameter("rolnombre", estado);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Usuariorol>();
		}
	}
}
