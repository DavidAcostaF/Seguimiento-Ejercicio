package pruebas;

import daos.Conexion;
import daos.EjercicioDAO;
import daos.EjercicioDiarioDAO;
import daos.IConexion;
import daos.IEjercicioDAO;
import daos.IEjercicioDiarioDAO;
import daos.IRutinaDAO;
import daos.RutinaDAO;
import dominio.Ejercicio;
import dominio.EjercicioDiario;
import dominio.Rutina;
import dominio.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alex_
 */
public class PruebasTablaEjercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IEjercicioDAO eDAO = new EjercicioDAO();
        IRutinaDAO rDAO = new RutinaDAO();
        IEjercicioDiarioDAO edDAO = new EjercicioDiarioDAO();
        IConexion conexion = new Conexion();
        
        Usuario u = new Usuario(2L);
        List<Rutina> rutinas = rDAO.obtenerRutinas(u);
        
        System.out.println("Rutina antes de agregar");
        for (Rutina rutina : rutinas) {
            System.out.println("Rutina ID: " + rutina.getId() + ", Día: " + rutina.getDia().getNombre());
            for (EjercicioDiario ej : rutina.getEjerciciosDiarios()) {
                System.out.println("Ejercicio: " + ej.getEjercicio().getNombre());
            }
        }
        System.out.println("");
        
        
        System.out.println("Se agrega un ejercicio");
        
        

        // Agregar un ejercicio
        EjercicioDiario nuevoEjercicio = edDAO.crear(new EjercicioDiario(new Ejercicio(26L), false, rutinas.get(6)));
        System.out.println("Ejercicio Diario creado con ID: " + nuevoEjercicio.getId() + "Dia: " + rutinas.get(6).getDia().getNombre());

        // Obtener rutinas nuevamente
        rutinas = rDAO.obtenerRutinas(u);
        System.out.println("Rutinas después de agregar el ejercicio:");
        for (Rutina rutina : rutinas) {
            System.out.println("Rutina ID: " + rutina.getId() + ", Día: " + rutina.getDia().getNombre());
            for (EjercicioDiario ej : rutina.getEjerciciosDiarios()) {
                System.out.println("Ejercicio: " + ej.getEjercicio().getNombre());
            }
        }

    }

}
