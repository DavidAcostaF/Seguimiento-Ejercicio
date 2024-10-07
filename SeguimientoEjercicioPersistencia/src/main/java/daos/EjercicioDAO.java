package daos;

import dominio.Ejercicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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

    @Override
    public Ejercicio modificarEjercicio(Long idEjercicio, Ejercicio nuevoEjercicio) {
        EntityManager entityManager = conexion.obtenerConexion();
        EntityTransaction transaction = entityManager.getTransaction();
        Ejercicio ejercicioActualizado = null;

        try {
            transaction.begin();
            Query query = entityManager.createQuery(
                    "UPDATE Ejercicio e SET e.nombre = :nuevoNombre, e.tipo = :nuevoTipo, e.duracion = :nuevaDuracion WHERE e.id = :idEjercicio"
            );
            query.setParameter("nuevoNombre", nuevoEjercicio.getNombre());
            query.setParameter("nuevoTipo", nuevoEjercicio.getTipo());
            query.setParameter("nuevaDuracion", nuevoEjercicio.getDuracion());
            query.setParameter("idEjercicio", idEjercicio);

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Se actualizo");

            } else {
                System.out.println("No se encontró un ejercicio con el ID: " + idEjercicio);
            }

            transaction.commit();
            ejercicioActualizado = entityManager.find(Ejercicio.class, idEjercicio);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();

        }

        return ejercicioActualizado;
    }

    @Override
    public boolean eliminarEjercicio(Long idEjercicio) {
        EntityManager entityManager = conexion.obtenerConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery(
                    "DELETE FROM Ejercicio e WHERE e.id = :idEjercicio"
            );
            query.setParameter("idEjercicio", idEjercicio);
            int rowsDeleted = query.executeUpdate();
            transaction.commit();
            // Retorna true si se eliminó al menos una fila
            return rowsDeleted > 0;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false; // Retorna false en caso de error
        } finally {
            entityManager.close();
        }
    }

}
