package rankingUsuarios;

import dtos.UsuarioDTO;
import java.util.Map;

/**
 *
 * @author alex_
 */
public class FRankingUsuario implements IRankingUsuario {

    private CRankingUsuario control;

    public FRankingUsuario() {
        this.control = new CRankingUsuario();
    }
    
    @Override
    public Map<String, Object> obtenerRanking(UsuarioDTO usuario) {
        return control.obtenerRanking(usuario);
    }
    
    
    
}
