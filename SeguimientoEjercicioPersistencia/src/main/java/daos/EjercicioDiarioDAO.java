package daos;

import dominio.EjercicioDiario;
import javax.persistence.EntityManager;

/**
 *
 * @author alex_
 */
public class EjercicioDiarioDAO implements IEjercicioDiarioDAO{

    private IConexion conexion;

    public EjercicioDiarioDAO() {
        this.conexion = new Conexion();
    }
    
    @Override
    public EjercicioDiario crear(EjercicioDiario ejercicio) {
        EntityManager entityManager = conexion.obtenerConexion();
        entityManager.getTransaction().begin();
        entityManager.persist(ejercicio);
        entityManager.getTransaction().commit();
        entityManager.refresh(ejercicio);
        entityManager.close();
        return ejercicio;
    }
    
    
    
}
