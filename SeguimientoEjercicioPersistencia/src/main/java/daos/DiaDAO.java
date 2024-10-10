package daos;

import dominio.Dia;
import dominio.DiaSemana;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DiaDAO implements IDiaDAO {

    private IConexion conexion;

    public DiaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Método que "siembra" los días de la semana en la base de datos siguiendo
     * el patrón get or create.
     */
    @Override
    public void seedDias() {
        EntityManager em = conexion.obtenerConexion();
        try {
            // Iteramos sobre los valores de la enumeración DiaSemana
            for (DiaSemana diaSemana : DiaSemana.values()) {
                Dia dia = getOrCreate(em, diaSemana);
                System.out.println("Día procesado: " + dia.getNombre());
            }

            System.out.println("Días de la semana procesados correctamente.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();  // Hacemos rollback en caso de error
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Método que busca un día en la base de datos y lo crea si no existe.
     *
     * @param em EntityManager para manejar la transacción.
     * @param diaSemana El valor del día que estamos buscando o creando.
     * @return La instancia de Dia existente o creada.
     */
    @Override
    public Dia getOrCreate(EntityManager em, DiaSemana diaSemana) {
        Dia dia;
        try {
            // Intentamos encontrar el día en la base de datos
            TypedQuery<Dia> query = em.createQuery(
                    "SELECT d FROM Dia d WHERE d.nombre = :nombre", Dia.class);
            query.setParameter("nombre", diaSemana);

            dia = query.getSingleResult();  // Recuperamos el día si existe
        } catch (NoResultException e) {
            em.getTransaction().begin();
            // Si no se encuentra el día, lo creamos y persistimos
            dia = new Dia(diaSemana);
            em.persist(dia);
            em.getTransaction().commit();
        }
        return dia;
    }

    @Override
    public List<Dia> lista() {
        EntityManager em = conexion.obtenerConexion();

        TypedQuery<Dia> query = em.createQuery("SELECT d FROM Dia d", Dia.class);
        return query.getResultList(); // Devuelve la lista de días
    }

    public boolean eliminar(Long id) {
        EntityManager em = conexion.obtenerConexion();
        try {
            em.getTransaction().begin();

            // Buscamos el día que queremos eliminar
            Dia dia = em.find(Dia.class, id);
            if (dia != null) {
                em.remove(dia);  // Si el día existe, lo eliminamos
                em.getTransaction().commit();
                System.out.println("Día eliminado correctamente.");
                return true;
            } else {
                System.out.println("El día no existe.");
                return false;
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();  // Hacemos rollback en caso de error
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}
