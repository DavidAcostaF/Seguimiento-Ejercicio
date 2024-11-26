package repository;

import dominio.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();  // Simula una base de datos en memoria

    // Método para guardar un usuario
    public void guardar(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarios;
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerPorId(Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Método para borrar un usuario
    public void borrar(Long id) {
        usuarios.removeIf(usuario -> usuario.getId().equals(id));  // Elimina el usuario con el ID dado
    }
}
