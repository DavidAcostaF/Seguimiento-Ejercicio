package pruebas;

import daos.IRutinaDAO;
import daos.IUsuarioDAO;
import daos.RutinaDAO;
import daos.UsuarioDAO;
import dominio.Dia;
import dominio.DiaSemana;
import dominio.EjercicioDiario;
import dominio.Rutina;
import dominio.Usuario;
import java.util.List;

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
                "jperez", 
                "Contra");
        Usuario usuarioEncontrado = usuarioDAO.obtener(usuarioExistente);
        System.out.println(usuarioEncontrado);
        
//        Dia martes = new Dia(2L);
//        Dia miercoles = new Dia(3L);
//        Dia jueves = new Dia(4L);
//        Dia viernes = new Dia(5L);
//        Dia sabado = new Dia(6L);
//        Dia domingo = new Dia(7L);
//        
//        Rutina rutinaMartes = new Rutina(usuarioEncontrado, martes);
//        Rutina rutinaMiercoles = new Rutina(usuarioEncontrado, miercoles);
//        Rutina rutinaJueves = new Rutina(usuarioEncontrado, jueves);
//        Rutina rutinaViernes = new Rutina(usuarioEncontrado, viernes);
//        Rutina rutinaSabado = new Rutina(usuarioEncontrado, sabado);
//        Rutina rutinaDomingo = new Rutina(usuarioEncontrado, domingo);
////        
//        // se crea la rutina
//        rutinaDAO.crearRutina(rutinaMartes);
//        rutinaDAO.crearRutina(rutinaMiercoles);
//        rutinaDAO.crearRutina(rutinaJueves);
//        rutinaDAO.crearRutina(rutinaViernes);
//        rutinaDAO.crearRutina(rutinaSabado);
//        rutinaDAO.crearRutina(rutinaDomingo);
        
//         Obtener rutinas
        List<Rutina> rutinasEncontradas = rutinaDAO.obtenerRutinas(usuarioEncontrado);
        
        for (Rutina rutinasEncontrada : rutinasEncontradas) {
            for (EjercicioDiario ej : rutinasEncontrada.getEjerciciosDiarios()) {
                System.out.println(ej);
            }
        }
        
        System.out.println(rutinasEncontradas.size());
        
    }
    
}
