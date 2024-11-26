package tests;

import dominio.Usuario;
import daos.UsuarioDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas para UsuarioDAO utilizando JUnit.
 */
public class UsuarioTests {

    @Test
    public void testCrearUsuario() {
        System.out.println("Ejecutando test: testCrearUsuario");

        // Inicializa UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crea un usuario
        Usuario usuario = new Usuario("David", "david123", "password", 30, 70.5f, 1.75f);

        // Guarda el usuario usando el método crear
        Usuario usuarioCreado = usuarioDAO.crear(usuario);

        // Asegura que el usuario se creó correctamente
        assertNotNull(usuarioCreado.getId(), "El ID del usuario no debería ser nulo después de crearlo.");
        assertEquals("David", usuarioCreado.getNombre());
        assertEquals("david123", usuarioCreado.getNomUsuario());

        // Borra el usuario creado después de la prueba
        usuarioDAO.borrar(usuarioCreado);

        // Verifica que el usuario se ha borrado
        Usuario usuarioBorrado = usuarioDAO.obtener(usuarioCreado);
        assertNull(usuarioBorrado, "El usuario debería ser nulo después de borrarlo.");
    }

    @Test
    public void testObtenerUsuario() {
        System.out.println("Ejecutando test: testObtenerUsuario");

        // Inicializa UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crea y guarda un usuario
        Usuario usuario = new Usuario("David", "david123", "password", 30, 70.5f, 1.75f);
        usuarioDAO.crear(usuario);

        // Obtiene el usuario usando el método obtener
        Usuario usuarioObtenido = usuarioDAO.obtener(usuario);

        // Asegura que el usuario fue encontrado correctamente
        assertNotNull(usuarioObtenido, "El usuario no debería ser nulo.");
        assertEquals("david123", usuarioObtenido.getNomUsuario());
        assertEquals("password", usuarioObtenido.getContrasenia());

        // Borra el usuario creado después de la prueba
        usuarioDAO.borrar(usuarioObtenido);

        // Verifica que el usuario se ha borrado
        Usuario usuarioBorrado = usuarioDAO.obtener(usuarioObtenido);
        assertNull(usuarioBorrado, "El usuario debería ser nulo después de borrarlo.");
    }

    @Test
    public void testBorrarUsuario() {
        System.out.println("Ejecutando test: testBorrarUsuario");

        // Inicializa UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crea y guarda un usuario
        Usuario usuario = new Usuario("David", "david123", "password", 30, 70.5f, 1.75f);
        usuarioDAO.crear(usuario);

        // Borra el usuario usando el método borrar
        usuarioDAO.borrar(usuario);

        // Intenta obtener el usuario después de borrarlo
        Usuario usuarioBorrado = usuarioDAO.obtener(usuario);

        // Asegura que el usuario fue borrado
        assertNull(usuarioBorrado, "El usuario debería ser nulo después de borrarlo.");
    }
}
