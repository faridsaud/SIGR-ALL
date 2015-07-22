package ec.edu.epn.modelo.jpa;

import ec.edu.epn.modelo.dao.GrupoDAO;
import ec.edu.epn.modelo.entity.Grupo;

public class JPAGrupoDAO extends JPAGenericDAO<Grupo, Integer>
implements GrupoDAO {

public JPAGrupoDAO() {
super(Grupo.class);
// TODO Auto-generated constructor stub
}
}
