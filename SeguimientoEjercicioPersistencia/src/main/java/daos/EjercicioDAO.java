package daos;

import dominio.Ejercicio;
import dominio.EjercicioDiario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author af_da
 */
public class EjercicioDAO implements IEjercicioDAO{
    private IConexion conexion;

    public EjercicioDAO() {
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
