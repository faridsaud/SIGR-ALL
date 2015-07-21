package ec.edu.epn.modelo.dao;

import ec.edu.epn.modelo.jpa.JPADAOFactory;


public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
        return factory;
    }

    public abstract CampoDAO getCampoDAO();

    public abstract ReactivoDAO getReactivoDAO();

    public abstract UsuarioDAO getUsuarioDAO();

    public abstract UsuariorolDAO getUsuariorolDAO();

    public abstract RolDAO getRolDAO();
}