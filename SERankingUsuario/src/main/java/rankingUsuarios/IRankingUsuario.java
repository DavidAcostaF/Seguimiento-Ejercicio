package rankingUsuarios;

import dtos.UsuarioDTO;
import java.util.Map;

/**
 *
 * @author alex_
 */
public interface IRankingUsuario {
    
    Map<String, Object> obtenerRanking(UsuarioDTO usuario);
    
}
