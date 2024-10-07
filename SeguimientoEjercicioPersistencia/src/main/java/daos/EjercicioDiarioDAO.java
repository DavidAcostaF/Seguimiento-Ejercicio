package daos;

import dominio.EjercicioDiario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
        System.out.println(ejercicio.getEjercicio().getId()+"Si que si ");
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
    
    
    
}
