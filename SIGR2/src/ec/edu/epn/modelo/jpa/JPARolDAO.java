package ec.edu.epn.modelo.jpa;

import ec.edu.epn.modelo.dao.RolDAO;
import ec.edu.epn.modelo.entity.Rol;

public class JPARolDAO extends JPAGenericDAO<Rol, Integer>
implements RolDAO {

public JPARolDAO() {
super(Rol.class);
// TODO Auto-generated constructor stub
}
}
