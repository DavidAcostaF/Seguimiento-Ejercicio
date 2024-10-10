package obtenerRutinas;

import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.List;
import negocio.IRutinaBO;
import negocio.RutinaBO;

/**
 *
 * @author alex_
 */
public class CObtenerRutinas {
    
    private IRutinaBO rutinaBO;

    protected CObtenerRutinas() {
        this.rutinaBO = new RutinaBO();
    }
    
    protected RutinaDTO obtenerRutina(UsuarioDTO usuario, int dia){
        return rutinaBO.obtenerRutina(usuario, dia);
    }
    
    protected List<RutinaDTO> obtenerRutinas(UsuarioDTO usuario){
        return rutinaBO.obtenerRutinas(usuario);
    }
    
}
