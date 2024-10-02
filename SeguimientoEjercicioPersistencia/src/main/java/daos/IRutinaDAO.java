package daos;

import dominio.Rutina;
import dominio.Usuario;

/**
 *
 * @author alex_
 */
public interface IRutinaDAO {
    
    public Rutina crearRutina(Rutina rutina);
    
    public Rutina obtenerRutinaUsuario(Usuario usuario);
    
}
