package conversores;

import dominio.Usuario;
import dtos.UsuarioDTO;

public class UsuarioConversor implements IConversor<Usuario,UsuarioDTO>{
    @Override
    public UsuarioDTO EntidadADTO(Usuario usuario) {
        if (usuario == null) {
            return null; // Manejo de null
        }
//        if (usuario.getId() != null ){
            return new UsuarioDTO(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getNomUsuario(),
            usuario.getContrasenia(),
            usuario.getEdad(),
            usuario.getPeso(),
            usuario.getEstatura()
        );
//        }
//        return new UsuarioDTO(
//            usuario.getId(),
//            usuario.getNombre(),
//            usuario.getNomUsuario(),
//            usuario.getContrasenia(),
//            usuario.getEdad(),
//            usuario.getPeso(),
//            usuario.getEstatura()
//        );
    }
    @Override
    public Usuario DTOAEntidad(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null; // Manejo de null
        }
        return new Usuario(
            usuarioDTO.id(),
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
