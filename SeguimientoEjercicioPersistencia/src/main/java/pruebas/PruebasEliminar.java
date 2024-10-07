package pruebas;

import daos.EjercicioDAO;
import daos.EjercicioDiarioDAO;
import daos.IEjercicioDAO;
import daos.IEjercicioDiarioDAO;
import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import dominio.Ejercicio;
import dominio.Usuario;

/**
 *
 * @author alex_
 */
public class PruebasEliminar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Obtener al usuario ya registrado
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioExistente = new Usuario( 
                "a", 
                "123");
        Usuario usuarioEncontrado = usuarioDAO.obtener(usuarioExistente);
        // Crear conexion con DAO
        IEjercicioDAO ejercicioDAO = new EjercicioDAO();
        IEjercicioDiarioDAO edDAO = new EjercicioDiarioDAO();
        // se obtiene el ejercicio base
        Ejercicio ejercicioEncontrado = ejercicioDAO.obtenerEjercicioNombre("ejercicio1");
        
        // eliminar
//        System.out.println(ejercicioDAO.eliminarEjercicio(ejercicioEncontrado.getId()));
        
        System.out.println(edDAO.eliminarEjercicioDiario(4L));
        
    }
    
}
