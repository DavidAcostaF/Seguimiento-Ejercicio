package pruebas;

import daos.IRutinaDAO;
import daos.IUsuarioDAO;
import daos.RutinaDAO;
import daos.UsuarioDAO;
import dominio.Rutina;
import dominio.Usuario;

/**
 *
 * @author alex_
 */
public class PruebasRutinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear la conexion
        IRutinaDAO rutinaDAO = new RutinaDAO();
        
        // El usuario crea una rutina
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioExistente = new Usuario( 
                "Jperez", 
                "Contra");
        Usuario usuarioEncontrado = usuarioDAO.obtener(usuarioExistente);
        
//        Rutina rutinaNueva = new Rutina(usuarioEncontrado);
//        
//        // se crea la rutina
//        rutinaDAO.crearRutina(rutinaNueva);
        
        // Obtener rutina
        Rutina rutinaEncontrada = rutinaDAO.obtenerRutinaUsuario(usuarioEncontrado);
        
        System.out.println(rutinaEncontrada);
        
    }
    
}
