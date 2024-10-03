package pruebas;

import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.List;
import negocio.IRutinaBO;
import negocio.IUsuarioBO;
import negocio.RutinaBO;
import negocio.UsuariosBO;

/**
 *
 * @author alex_
 */
public class PruebasObtenerRutinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IUsuarioBO usuarioNegocio = new UsuariosBO();
        UsuarioDTO usuario = new UsuarioDTO(
                -1L, 
                "Juan", 
                "jperez", 
                "Contra", 
                0, 
                0, 
                0);
        
        UsuarioDTO uEncontrado = usuarioNegocio.loginUsuario(usuario);
        
        System.out.println(uEncontrado);
        
        IRutinaBO rNegocio = new RutinaBO();
        
        List<RutinaDTO> rutinasObtenidas = rNegocio.obtenerRutinas(uEncontrado);
        
        for (RutinaDTO rutinasObtenida : rutinasObtenidas) {
            System.out.println("");
            System.out.println(rutinasObtenida.ejerciciosDiarios());
        }
        
    }
    
}
