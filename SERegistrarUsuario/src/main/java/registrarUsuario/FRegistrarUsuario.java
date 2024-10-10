package registrarUsuario;

import dtos.UsuarioDTO;

/**
 *
 * @author alex_
 */
public class FRegistrarUsuario implements IRegistrarUsuario{

    private CRegistrarUsuario control;

    public FRegistrarUsuario() {
        this.control = new CRegistrarUsuario();
    }
    
    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario) {
        return control.registrarUsuarioNuevo(usuario);
    }
    
}
