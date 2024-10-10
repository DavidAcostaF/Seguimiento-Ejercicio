package registrarUsuario;

import dtos.UsuarioDTO;
import negocio.IUsuarioBO;
import negocio.UsuariosBO;

/**
 *
 * @author alex_
 */
public class CRegistrarUsuario {
    
    private IUsuarioBO usuarioBO;

    protected CRegistrarUsuario() {
        this.usuarioBO = new UsuariosBO();
    }
    
    protected UsuarioDTO registrarUsuarioNuevo(UsuarioDTO usuario){
    
        return usuarioBO.crearUsuario(usuario);
        
    }
    
}
