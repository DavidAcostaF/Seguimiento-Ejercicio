package daos;

import dominio.Ejercicio;
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
    public Ejercicio crear(Ejercicio ejercicio) {
        EntityManager entityManager = conexion.obtenerConexion();
        entityManager.getTransaction().begin();
        entityManager.persist(ejercicio);
        entityManager.getTransaction().commit();
        entityManager.refresh(ejercicio);
        entityManager.close();
        return ejercicio;
    }

    @Override
    public Ejercicio obtenerEjercicioNombre(String nombre) {
        EntityManager entityManager = conexion.obtenerConexion();
        List<Ejercicio> rutinasEncontradas = entityManager.createQuery(
                "SELECT e FROM Ejercicio e WHERE e.nombre = :nombre_ejercicio", Ejercicio.class)
                .setParameter("nombre_ejercicio", nombre)
                .getResultList();

        return rutinasEncontradas.isEmpty() ? null : rutinasEncontradas.get(0);
    }
    
}
