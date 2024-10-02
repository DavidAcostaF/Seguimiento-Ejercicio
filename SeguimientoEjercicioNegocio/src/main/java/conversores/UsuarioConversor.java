package conversores;

import dominio.Usuario;
import dtos.UsuarioDTO;

public class UsuarioConversor {

    public UsuarioDTO EntidadADTO(Usuario usuario) {
        if (usuario == null) {
            return null; // Manejo de null
        }
        return new UsuarioDTO(
            usuario.getNombre(),
            usuario.getNomUsuario(),
            usuario.getContrasenia(),
            usuario.getEdad(),
            usuario.getPeso(),
            usuario.getEstatura()
        );
    }

    public Usuario DTOAEntidad(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null; // Manejo de null
        }
        return new Usuario(
            usuarioDTO.nombre(),
            usuarioDTO.nomUsuario(),
            usuarioDTO.contrasenia(),
            usuarioDTO.edad(),
            usuarioDTO.peso(),
            usuarioDTO.estatura(),
            null // Asumiendo que el planEntrenamiento es null o manejarlo de otra forma
        );
    }
}
