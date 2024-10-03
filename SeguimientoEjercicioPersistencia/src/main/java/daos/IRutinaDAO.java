package daos;

import dominio.Rutina;
import dominio.Usuario;
import java.util.List;

/**
 *
 * @author alex_
 */
public interface IRutinaDAO {
    
    public Rutina crearRutina(Rutina rutina);
    
    public List<Rutina> obtenerRutinaUsuario(Usuario usuario);
    
}
