package tests;

import dominio.*;
import daos.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RutinaTests {

    private EntityManager em = Persistence.createEntityManagerFactory("SeguimientoEjercicioPU").createEntityManager();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private DiaDAO diaDAO = new DiaDAO();
    private RutinaDAO rutinaDAO = new RutinaDAO();

    // Para almacenar los objetos creados
    private Usuario usuario;
    private Dia dia;
    private Rutina rutina;

    @AfterEach
    public void tearDown() {
        // Eliminar Rutina
        if (rutina != null) {
            rutinaDAO.eliminar(rutina.getId());
        }
        // Eliminar Día
        if (dia != null) {
            diaDAO.eliminar(dia.getId());
        }
        // Eliminar Usuario
        if (usuario != null) {
            usuarioDAO.borrar(usuario);
        }
    }

    @Test
    public void testCrearRutina() {
        // Inicializar Usuario
        usuario = crearUsuario("Test User", "testRutina");

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        dia = diaDAO.getOrCreate(em, DiaSemana.LUNES); // Guarda o recupera el día

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(dia);
        rutina.setUsuario(usuario);

        // Crear Rutina
        Rutina creada = rutinaDAO.crearRutina(rutina);

        // Verificar que se haya creado correctamente
        assertNotNull(creada);
        assertEquals(creada.getDia().getNombre(), DiaSemana.LUNES);
        assertEquals(creada.getUsuario().getId(), usuario.getId());
    }

    @Test
    public void testActualizarRutina() {
        usuario = crearUsuario("Test User", "testActualizar");

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        dia = diaDAO.getOrCreate(em, DiaSemana.LUNES);

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(dia);
        rutina.setUsuario(usuario);
        rutina = rutinaDAO.crearRutina(rutina);

        // Actualizar Rutina
        rutina.setDia(dia); // Cambiar el día
        Rutina actualizada = rutinaDAO.crearRutina(rutina);

        // Verificar que se haya actualizado correctamente
        assertNotNull(actualizada);
        assertEquals(actualizada.getDia().getNombre(), DiaSemana.LUNES);
    }

    @Test
    public void testEliminarRutina() {
        usuario = crearUsuario("Test User", "testEliminar");

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        dia = diaDAO.getOrCreate(em, DiaSemana.LUNES);

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(dia);
        rutina.setUsuario(usuario);
        rutina = rutinaDAO.crearRutina(rutina);

        // Eliminar Rutina
        boolean eliminado = rutinaDAO.eliminar(rutina.getId());

        // Verificar que se haya eliminado correctamente
        assertTrue(eliminado);
    }

    @Test
    public void testObtenerRutinaUsuarioDia() {
        usuario = crearUsuario("Test User", "testObtener");

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        dia = diaDAO.getOrCreate(em, DiaSemana.LUNES);

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(dia);
        rutina.setUsuario(usuario);
        rutina = rutinaDAO.crearRutina(rutina);

        // Obtener Rutina por Usuario y Día
        Rutina obtenida = rutinaDAO.obtenerRutinaUsuarioDia(usuario, Integer.parseInt(String.valueOf(dia.getId())));

        // Verificar que se haya obtenido correctamente
        assertNotNull(obtenida);
        assertEquals(obtenida.getDia().getNombre(), DiaSemana.LUNES);
    }

    private Usuario crearUsuario(String nombre, String nomUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setNomUsuario(nomUsuario);
        usuario.setContrasenia("password123");
        usuario.setEdad(30);
        usuario.setPeso(70.0f);
        usuario.setEstatura(1.75f);
        return usuarioDAO.crear(usuario);
    }
}
