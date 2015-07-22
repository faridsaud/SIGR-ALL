package ec.edu.epn.modelo.jpa;

import ec.edu.epn.modelo.dao.CarreraDAO;
import ec.edu.epn.modelo.entity.Carrera;

public class JPACarreraDAO extends JPAGenericDAO<Carrera, Integer>
implements CarreraDAO {

public JPACarreraDAO() {
super(Carrera.class);
// TODO Auto-generated constructor stub
}
}
