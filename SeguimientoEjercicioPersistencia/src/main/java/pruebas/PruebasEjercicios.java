package pruebas;

import daos.EjercicioDAO;
import daos.EjercicioDiarioDAO;
import daos.IEjercicioDAO;
import daos.IEjercicioDiarioDAO;
import daos.IRutinaDAO;
import daos.IUsuarioDAO;
import daos.RutinaDAO;
import daos.UsuarioDAO;
import dominio.Dia;
import dominio.DiaSemana;
import dominio.Ejercicio;
import dominio.EjercicioDiario;
import dominio.Rutina;
import dominio.Usuario;
import java.util.List;

/**
 *
 * @author alex_
 */
public class PruebasEjercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Obtener al usuario ya registrado
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioExistente = new Usuario( 
                "Jperez", 
                "Contra");
        Usuario usuarioEncontrado = usuarioDAO.obtener(usuarioExistente);
        
        // Obtener rutina del usuario
        IRutinaDAO rutinaDAO = new RutinaDAO();
//        List<Rutina> rutinaEncontrada = rutinaDAO.obtenerRutinaUsuario(usuarioEncontrado);
        
        // Crear conexion con DAO
        IEjercicioDAO ejercicioDAO = new EjercicioDAO();
//        
//        // crear ejercicio base
//        Ejercicio ejercicioBase = new Ejercicio(
//                "Caminata", 
//                "Cardio", 
//                15.00f);
//        
//        // se crea la persistencia del ejercicio base
//        ejercicioDAO.crear(ejercicioBase);
        
        // se obtiene el ejercicio base
        Ejercicio ejercicioEncontrado = ejercicioDAO.obtenerEjercicioNombre("Caminata");
        
        // crear el ejercicio con los dias de entrenamiento
//        EjercicioDiario ejercicioLunes = new EjercicioDiario(
//                ejercicioEncontrado,  
//                false, 
//                rutinaEncontrada.get(2));
        
        // persistencia del ejercicio con dia
//        IEjercicioDiarioDAO ejercicioDiaDAO = new EjercicioDiarioDAO();
        
//        ejercicioDiaDAO.crear(ejercicioLunes);
        
        
    }
    
}
