package daos;

import dominio.EjercicioDiario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author alex_
 */
public class EjercicioDiarioDAO implements IEjercicioDiarioDAO {

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

    @Override
    public boolean eliminarEjercicioDiario(Long idEjercicio) {
        EntityManager entityManager = conexion.obtenerConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery(
                    "DELETE FROM EjercicioDiario e WHERE e.id = :idEjercicio"
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

    @Override
    public EjercicioDiario obtener(EjercicioDiario ejercicio,String nombreDia) {
        EntityManager entityManager = conexion.obtenerConexion();
        System.out.println(ejercicio.getRutina().getDia());
        TypedQuery<EjercicioDiario> query = entityManager.createQuery(
                "SELECT e FROM EjercicioDiario e WHERE e.ejercicio.nombre = :nombreEjercicio AND e.rutina.dia.nombre = :nombreDia AND e.rutina.usuario = :usuario",
                EjercicioDiario.class);
        query.setParameter("nombreEjercicio", ejercicio.getEjercicio().getNombre());
        query.setParameter("nombreDia", ejercicio.getRutina().getDia().getNombre());
        query.setParameter("usuario", ejercicio.getRutina().getUsuario());

        // Devolver el resultado, o manejar el caso de que no se encuentre nada
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Manejo de la excepción si no se encuentra ningún resultado
            return null;
        }
    }

    @Override
    public EjercicioDiario actualizar(EjercicioDiario ejercicio) {
        EntityManager entityManager = conexion.obtenerConexion();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualiza el estado del ejercicio directamente usando merge
            EjercicioDiario ejercicioActualizado = entityManager.merge(ejercicio);

            transaction.commit(); // Confirmar la transacción
            return ejercicioActualizado; // Retorna el objeto actualizado
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Revertir en caso de error
            }
            e.printStackTrace(); // Manejo simple de excepciones
            throw e; // Vuelve a lanzar la excepción
        } finally {
            entityManager.close(); // Asegura el cierre del EntityManager
        }
    }

}
