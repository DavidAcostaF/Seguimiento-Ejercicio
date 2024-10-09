package daos;

import dominio.Rutina;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alex_
 */
public class RutinaDAO implements IRutinaDAO{

    private IConexion conexion;

    public RutinaDAO() {
        this.conexion = new Conexion();
    }
    
    @Override
    public Rutina crearRutina(Rutina rutina) {
        EntityManager entityManager = conexion.obtenerConexion();
        entityManager.getTransaction().begin();
        entityManager.persist(rutina);
        entityManager.getTransaction().commit();
        entityManager.refresh(rutina);
        entityManager.clear();
        entityManager.close();
        
        return rutina;

    }

    @Override
    public Rutina obtenerRutinaUsuarioDia(Usuario usuario, int dia) {
        EntityManager entityManager = conexion.obtenerConexion();
        Rutina rutinaEncontrada = null;

        try {
            rutinaEncontrada = entityManager.createQuery(
                    "SELECT r FROM Rutina r WHERE r.usuario.id = :id_usuario AND r.dia.id = :dia_id", Rutina.class)
                    .setParameter("id_usuario", usuario.getId())
                    .setParameter("dia_id", dia)
                    .getSingleResult();

            entityManager.clear();
        } finally {
            entityManager.close();
        }

        return rutinaEncontrada;
    }

    @Override
    public List<Rutina> obtenerRutinas(Usuario usuario) {
        EntityManager entityManager = conexion.obtenerConexion();
        List<Rutina> rutinaEncontradas = new ArrayList<>();

        try {
            // Obtener la lista de rutinas desde la base de datos
            rutinaEncontradas = entityManager.createQuery(
                    "SELECT r FROM Rutina r WHERE r.usuario.id = :id_usuario", Rutina.class)
                    .setParameter("id_usuario", usuario.getId())
                    .getResultList();

            // Refrescar cada rutina en la lista
            for (Rutina rutina : rutinaEncontradas) {
                if (entityManager.contains(rutina)) {
                    entityManager.refresh(rutina); // Forzar la recarga desde la base de datos
                } else {
                    // Si la rutina no está gestionada, buscarla de nuevo para que lo esté
                    rutina = entityManager.find(Rutina.class, rutina.getId());
                    entityManager.refresh(rutina); // Luego refrescarla
                }
            }

            entityManager.clear(); 
        } finally {
            entityManager.close(); 
        }

        return rutinaEncontradas;
    }

}
