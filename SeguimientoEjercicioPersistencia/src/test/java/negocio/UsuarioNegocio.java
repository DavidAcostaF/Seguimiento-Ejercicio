package negocio;

import repository.UsuarioRepository;
import dominio.Usuario;

import java.util.List;

public class UsuarioNegocio {

    private final UsuarioRepository usuarioRepository;

    // Constructor
    public UsuarioNegocio(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void crearUsuario(Long id, String nombre) {
        Usuario usuario = new Usuario(id, nombre);
        usuarioRepository.guardar(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.obtenerTodos();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.obtenerPorId(id);
    }

    public void borrarUsuario(Long id) {
        usuarioRepository.borrar(id);  // Invoca al método de borrar en el repository
    }
}
