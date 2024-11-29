package obtenerUsuarios;

import dtos.UsuarioDTO;
import negocio.IUsuarioBO;
import negocio.UsuariosBO;

/**
 *
 * @author alex_
 */
public class CObtenerUsuarios {
    
    private IUsuarioBO usuarioBO;

    protected CObtenerUsuarios() {
        this.usuarioBO = new UsuariosBO();
    }
    
    protected UsuarioDTO obtenerUsuario(UsuarioDTO usuario){
        return usuarioBO.loginUsuario(usuario);
    }
    
    protected boolean verificarUsuarioExistente(String nombreUsuario){
        return usuarioBO.verificarUsuarioExistente(nombreUsuario);
    }
    
}
