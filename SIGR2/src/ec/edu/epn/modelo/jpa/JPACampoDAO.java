package ec.edu.epn.modelo.jpa;

import ec.edu.epn.modelo.dao.CampoDAO;
import ec.edu.epn.modelo.entity.Campo;

public class JPACampoDAO extends JPAGenericDAO<Campo, Integer>
implements CampoDAO {

public JPACampoDAO() {
super(Campo.class);
// TODO Auto-generated constructor stub
}
}
