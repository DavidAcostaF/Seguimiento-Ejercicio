package negocio;

import dominio.Usuario;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author af_da
 */
public interface IRutinaBO {
    void crearRutina(RutinaDTO rutina);
    RutinaDTO obtenerRutina(UsuarioDTO usuario,int dia);
    List<RutinaDTO> obtenerRutinas(UsuarioDTO usuario);
}
