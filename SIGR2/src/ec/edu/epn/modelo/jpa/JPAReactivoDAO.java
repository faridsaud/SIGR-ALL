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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reactivo> findAllbyEstadoAsignacion(String estadoAsignacionReactivo) {
		try {
			Query query = em.createNamedQuery("Reactivo.findAllbyEstadoAsignacion");
			query.setParameter("estadoAsignacionReactivo", estadoAsignacionReactivo);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Reactivo>();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reactivo> findReactivosPorAsignar() {
		try {
			Query query = em.createNamedQuery("Reactivo.findReactivosPorAsignar");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Reactivo>();
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reactivo> 	findReactivosPorReasignar() {
		try {
			Query query = em.createNamedQuery("Reactivo.findReactivosPorReasignar");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Reactivo>();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reactivo> findReactivosPorAsignarByTopico(String nombreTopico) {
		try {
			Query query = em.createNamedQuery("Reactivo.findReactivosPorAsignarByTopico");
			query.setParameter("nombreTopico", nombreTopico);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Reactivo>();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reactivo> findByTipoAndByEstado(String estadoReactivo, String tipoReactivo) {
		try {
			Query query = em.createNamedQuery("Reactivo.findByTipoAndByEstado");
			query.setParameter("estadoReactivo", estadoReactivo);
			query.setParameter("tipoReactivo", tipoReactivo);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Reactivo>();
		}
	}


}
