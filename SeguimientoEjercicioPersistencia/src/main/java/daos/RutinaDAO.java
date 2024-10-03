package daos;

import dominio.Rutina;
import dominio.Usuario;
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
        entityManager.close();
        return rutina;
        
    }

    @Override
    public List<Rutina> obtenerRutinaUsuario(Usuario usuario) {
        EntityManager entityManager = conexion.obtenerConexion();
        List<Rutina> rutinasEncontradas = entityManager.createQuery(
                "SELECT r FROM Rutina r WHERE r.usuario.id = :id_usuario", Rutina.class)
                .setParameter("id_usuario", usuario.getId())
                .getResultList();

        return rutinasEncontradas;
    }

}
