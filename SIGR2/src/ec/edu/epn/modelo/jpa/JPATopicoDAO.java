package ec.edu.epn.modelo.jpa;

import ec.edu.epn.modelo.dao.TopicoDAO;
import ec.edu.epn.modelo.entity.Topico;

public class JPATopicoDAO extends JPAGenericDAO<Topico, Integer>
implements TopicoDAO {

public JPATopicoDAO() {
super(Topico.class);
// TODO Auto-generated constructor stub
}
}
