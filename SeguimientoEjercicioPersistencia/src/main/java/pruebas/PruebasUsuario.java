package pruebas;

import daos.Conexion;
import daos.IConexion;
import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import dominio.Usuario;


/**
 *
 * @author alex_
 */
public class PruebasUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Prueba registro de usuario
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        
        // Se crea al usuario
        Usuario usuarioNuevo = new Usuario(
                "Juan Perez", 
                "Jperez", 
                "Contra", 
                26, 
                75, 
                1.78f);
        
        // se guarda en la base
        usuarioDAO.crear(usuarioNuevo);
        
        
    }
    
}
