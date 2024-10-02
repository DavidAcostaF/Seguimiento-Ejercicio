package daos;

import dominio.Rutina;
import dominio.Usuario;
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
    
}
