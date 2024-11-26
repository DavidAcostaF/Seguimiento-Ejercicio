package mock;

import repository.UsuarioRepository;
import dominio.Usuario;
import negocio.UsuarioNegocio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Mock
    private UsuarioRepository usuarioDAO;  // Simulamos el UsuarioDAO con Mockito

    @InjectMocks
    private UsuarioNegocio usuarioNegocio;  // Creamos el negocio y lo inyectamos

    @BeforeEach
    public void setUp() {
        // Inicializa los mocks antes de cada prueba
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearYObtenerUsuarios() {
        // Impresión que describe lo que hace este test
        System.out.println("Test: Crear y obtener usuarios");
        System.out.println("Este test simula la creación de dos usuarios y verifica que " +
                "se guarden correctamente en la lista, y luego se obtengan al llamar al negocio.");

        // Simulamos el comportamiento del UsuarioDAO
        when(usuarioDAO.obtenerTodos()).thenReturn(List.of(new Usuario(1L, "Juan Perez"), new Usuario(2L, "Ana Gomez")));

        // Invocamos el método del negocio para crear un usuario
        usuarioNegocio.crearUsuario(1L, "Juan Perez");
        usuarioNegocio.crearUsuario(2L, "Ana Gomez");

        // Verificamos que los métodos de UsuarioDAO fueron llamados
        verify(usuarioDAO, times(2)).guardar(any(Usuario.class));

        // Ahora verificamos que obtenerTodos devuelve los usuarios correctos
        List<Usuario> usuarios = usuarioNegocio.obtenerUsuarios();

        // Aseguramos que la lista contiene los usuarios correctos
        assertEquals(2, usuarios.size());
        assertEquals("Juan Perez", usuarios.get(0).getNombre());
        assertEquals("Ana Gomez", usuarios.get(1).getNombre());
    }

    @Test
    public void testObtenerUsuarioPorId() {
        // Impresión que describe lo que hace este test
        System.out.println("Test: Obtener usuario por ID");
        System.out.println("Este test simula la obtención de un usuario por su ID y verifica que " +
                "se recupere correctamente la información del usuario.");

        // Simulamos un usuario específico con id = 1
        when(usuarioDAO.obtenerPorId(1L)).thenReturn(new Usuario(1L, "Juan Perez"));

        // Verificamos que el método obtiene correctamente el usuario
        Usuario usuario = usuarioNegocio.obtenerUsuarioPorId(1L);

        // Verificamos que el nombre del usuario es correcto
        assertNotNull(usuario);
        assertEquals("Juan Perez", usuario.getNombre());
    }

    @Test
    public void testBorrarUsuario() {
        // Impresión que describe lo que hace este test
        System.out.println("Test: Borrar usuario");
        System.out.println("Este test simula el borrado de un usuario y verifica que " +
                "el usuario se elimine correctamente de la lista.");

        // Preparamos el usuario para borrar
        Long usuarioId = 1L;
        Usuario usuarioABorrar = new Usuario(usuarioId, "Juan Perez");

        // Simulamos el comportamiento del método de borrado
        doNothing().when(usuarioDAO).borrar(usuarioId);  // Simula la llamada al DAO para borrar el usuario

        // Llamamos al método de negocio para borrar el usuario
        usuarioNegocio.borrarUsuario(usuarioId);

        // Verificamos que el método borrar fue invocado con el ID correcto
        verify(usuarioDAO, times(1)).borrar(usuarioId);

        // Verificamos que el usuario fue efectivamente eliminado (no estará en la lista)
        List<Usuario> usuarios = usuarioNegocio.obtenerUsuarios();
        assertTrue(usuarios.isEmpty());  // En este caso, debería estar vacío porque eliminamos al usuario
    }
}
