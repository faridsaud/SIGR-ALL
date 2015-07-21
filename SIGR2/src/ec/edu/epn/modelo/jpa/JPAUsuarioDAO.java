package ec.edu.epn.modelo.jpa;

import ec.edu.epn.modelo.dao.UsuarioDAO;
import ec.edu.epn.modelo.entity.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer>
implements UsuarioDAO {

public JPAUsuarioDAO() {
super(Usuario.class);
// TODO Auto-generated constructor stub
}
}
