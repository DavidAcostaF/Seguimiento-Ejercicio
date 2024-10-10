package tests;

import dominio.*;
import daos.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EjercicioDiarioTests {

    private EntityManager em = Persistence.createEntityManagerFactory("SeguimientoEjercicioPU").createEntityManager();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private DiaDAO diaDAO = new DiaDAO();
    private RutinaDAO rutinaDAO = new RutinaDAO();
    private EjercicioDAO ejercicioDAO = new EjercicioDAO();
    private IEjercicioDiarioDAO ejercicioDiarioDAO = new EjercicioDiarioDAO();

    // Para almacenar los objetos creados
    private Usuario usuario;
    private Dia dia;
    private Rutina rutina;
    private Ejercicio ejercicio;
    private EjercicioDiario ejercicioDiario;

    @AfterEach
    public void tearDown() {
        // Eliminar EjercicioDiario
        if (ejercicioDiario != null) {
            ejercicioDiarioDAO.eliminarEjercicioDiario(ejercicioDiario.getId());
        }
        // Eliminar Ejercicio
        if (ejercicio != null) {
            ejercicioDAO.eliminarEjercicio(ejercicio.getId());
        }
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
    public void testCrearEjercicioDiario() {
        // Inicializar Usuario
        usuario = crearUsuario("Test User", "test"); // Cambiar el nombre de usuario para evitar duplicados

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        Dia diaGuardado = diaDAO.getOrCreate(em, DiaSemana.LUNES);

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(diaGuardado);
        rutina.setUsuario(usuario);
        rutina = rutinaDAO.crearRutina(rutina);

        // Inicializar Ejercicio
        ejercicio = new Ejercicio();
        ejercicio.setNombre("Ejercicio Test");
        ejercicio.setTipo("Cardio"); // Asegúrate de establecer un tipo adecuado
        ejercicio = ejercicioDAO.crear(ejercicio);

        // Inicializar EjercicioDiario
        ejercicioDiario = new EjercicioDiario();
        ejercicioDiario.setEjercicio(ejercicio);
        ejercicioDiario.setCompletado(false);
        ejercicioDiario.setRutina(rutina);
        ejercicioDiario.setActivo(true);

        // Crear EjercicioDiario
        EjercicioDiario creado = ejercicioDiarioDAO.crear(ejercicioDiario);

        // Verificar que se haya creado correctamente
        assertNotNull(creado);
        assertEquals(creado.getEjercicio().getNombre(), "Ejercicio Test");
    }

    @Test
    public void testActualizarEjercicioDiario() {
        usuario = crearUsuario("Test User", "test2"); // Cambiar el nombre de usuario

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        Dia diaGuardado = diaDAO.getOrCreate(em, DiaSemana.LUNES);

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(diaGuardado);
        rutina.setUsuario(usuario);
        rutina = rutinaDAO.crearRutina(rutina);

        // Inicializar Ejercicio
        ejercicio = new Ejercicio();
        ejercicio.setNombre("Ejercicio Test");
        ejercicio.setTipo("Cardio");
        ejercicio = ejercicioDAO.crear(ejercicio);

        // Inicializar EjercicioDiario
        ejercicioDiario = new EjercicioDiario();
        ejercicioDiario.setEjercicio(ejercicio);
        ejercicioDiario.setCompletado(false);
        ejercicioDiario.setRutina(rutina);
        ejercicioDiario.setActivo(true);

        // Crear EjercicioDiario
        EjercicioDiario creado = ejercicioDiarioDAO.crear(ejercicioDiario);

        // Actualizar EjercicioDiario
        creado.setCompletado(true);
        EjercicioDiario actualizado = ejercicioDiarioDAO.actualizar(creado);

        // Verificar que se haya actualizado correctamente
        assertNotNull(actualizado);
        assertTrue(actualizado.isCompletado());
    }

    @Test
    public void testEliminarEjercicioDiario() {
        usuario = crearUsuario("Test User", "test3"); // Cambiar el nombre de usuario

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        Dia diaGuardado = diaDAO.getOrCreate(em, DiaSemana.LUNES);

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(diaGuardado);
        rutina.setUsuario(usuario);
        rutina = rutinaDAO.crearRutina(rutina);

        // Inicializar Ejercicio
        ejercicio = new Ejercicio();
        ejercicio.setNombre("Ejercicio Test");
        ejercicio.setTipo("Cardio");
        ejercicio = ejercicioDAO.crear(ejercicio);

        // Inicializar EjercicioDiario
        ejercicioDiario = new EjercicioDiario();
        ejercicioDiario.setEjercicio(ejercicio);
        ejercicioDiario.setCompletado(false);
        ejercicioDiario.setRutina(rutina);
        ejercicioDiario.setActivo(true);

        // Crear EjercicioDiario
        EjercicioDiario creado = ejercicioDiarioDAO.crear(ejercicioDiario);

        // Eliminar EjercicioDiario
        boolean eliminado = ejercicioDiarioDAO.eliminarEjercicioDiario(creado.getId());

        // Verificar que se haya eliminado correctamente
        assertTrue(eliminado);
    }

    @Test
    public void testObtenerEjercicioDiario() {
        usuario = crearUsuario("Test User", "test4"); // Cambiar el nombre de usuario

        // Inicializar Día
        dia = new Dia();
        dia.setNombre(DiaSemana.LUNES);
        Dia diaGuardado = diaDAO.getOrCreate(em, DiaSemana.LUNES);

        // Inicializar Rutina
        rutina = new Rutina();
        rutina.setDia(diaGuardado);
        rutina.setUsuario(usuario);
        rutina = rutinaDAO.crearRutina(rutina);

        // Inicializar Ejercicio
        ejercicio = new Ejercicio();
        ejercicio.setNombre("Ejercicio Test");
        ejercicio.setTipo("Cardio");
        ejercicio = ejercicioDAO.crear(ejercicio);

        // Inicializar EjercicioDiario
        ejercicioDiario = new EjercicioDiario();
        ejercicioDiario.setEjercicio(ejercicio);
        ejercicioDiario.setCompletado(false);
        ejercicioDiario.setRutina(rutina);
        ejercicioDiario.setActivo(true);

        // Crear EjercicioDiario
        EjercicioDiario creado = ejercicioDiarioDAO.crear(ejercicioDiario);

        // Obtener EjercicioDiario
        EjercicioDiario obtenido = ejercicioDiarioDAO.obtener(creado,DiaSemana.LUNES.toString());

        // Verificar que se haya obtenido correctamente
        assertNotNull(obtenido);
        assertEquals(obtenido.getEjercicio().getNombre(), "Ejercicio Test");
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
