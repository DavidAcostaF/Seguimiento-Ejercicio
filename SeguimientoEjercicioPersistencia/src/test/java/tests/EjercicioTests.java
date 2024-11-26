package tests;

import daos.EjercicioDAO;
import daos.IEjercicioDAO;
import dominio.Ejercicio;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EjercicioTests {

    @Test
    public void testCrearEjercicio() {
        System.out.println("Ejecutando test: testCrearEjercicio");

        IEjercicioDAO ejercicioDAO = new EjercicioDAO(); // Inicializa dentro del test

        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombre("Correr");
        ejercicio.setTipo("Aeróbico");
        ejercicio.setDuracion(30.0f);

        Ejercicio creado = ejercicioDAO.crear(ejercicio);
        assertNotNull(creado);
        assertEquals(ejercicio.getNombre(), creado.getNombre());
        assertEquals(ejercicio.getTipo(), creado.getTipo());
        assertEquals(ejercicio.getDuracion(), creado.getDuracion());
    }

    @Test
    public void testObtenerEjercicioNombre() {
        System.out.println("Ejecutando test: testObtenerEjercicioNombre");

        IEjercicioDAO ejercicioDAO = new EjercicioDAO(); // Inicializa dentro del test

        // Suponiendo que ya existe un ejercicio con el nombre "Correr"
        Ejercicio ejercicio = ejercicioDAO.obtenerEjercicioNombre("Correr");
        assertNotNull(ejercicio);
        assertEquals("Correr", ejercicio.getNombre());
    }

    @Test
    public void testModificarEjercicio() {
        System.out.println("Ejecutando test: testModificarEjercicio");

        IEjercicioDAO ejercicioDAO = new EjercicioDAO(); // Inicializa dentro del test

        // Crear un nuevo ejercicio
        Ejercicio nuevoEjercicioCreado = new Ejercicio();
        nuevoEjercicioCreado.setNombre("Correr");
        nuevoEjercicioCreado.setTipo("Aeróbico");
        nuevoEjercicioCreado.setDuracion(30.0f);

        // Guardar el nuevo ejercicio en la base de datos
        Ejercicio ejercicioGuardado = ejercicioDAO.crear(nuevoEjercicioCreado);
        assertNotNull(ejercicioGuardado, "El ejercicio creado no debería ser nulo.");

        // Modificar el ejercicio
        Ejercicio ejercicioParaModificar = new Ejercicio();
        ejercicioParaModificar.setNombre("Correr Lento");
        ejercicioParaModificar.setTipo("Aeróbico");
        ejercicioParaModificar.setDuracion(40.0f);

        Ejercicio modificado = ejercicioDAO.modificarEjercicio(ejercicioGuardado.getId(), ejercicioParaModificar);
        assertNotNull(modificado);
        assertEquals(ejercicioParaModificar.getNombre(), modificado.getNombre());
        assertEquals(ejercicioParaModificar.getTipo(), modificado.getTipo());
        assertEquals(ejercicioParaModificar.getDuracion(), modificado.getDuracion());

        // Eliminar el ejercicio modificado
        boolean eliminado = ejercicioDAO.eliminarEjercicio(modificado.getId());
        assertTrue(eliminado, "El ejercicio debería haberse eliminado.");

        // Verificar que el ejercicio fue eliminado
        Ejercicio ejercicioEliminado = ejercicioDAO.obtenerEjercicioNombre(modificado.getNombre());
        assertNull(ejercicioEliminado, "El ejercicio debería ser nulo después de la eliminación.");
    }

    @Test
    public void testEliminarEjercicio() {
        System.out.println("Ejecutando test: testEliminarEjercicio");

        IEjercicioDAO ejercicioDAO = new EjercicioDAO(); // Inicializa dentro del test

        // Crear un nuevo ejercicio
        Ejercicio nuevoEjercicio = new Ejercicio();
        nuevoEjercicio.setNombre("Correr Lento");
        nuevoEjercicio.setTipo("Aeróbico");
        nuevoEjercicio.setDuracion(30.0f);

        // Guardar el nuevo ejercicio en la base de datos
        Ejercicio ejercicioGuardado = ejercicioDAO.crear(nuevoEjercicio);
        assertNotNull(ejercicioGuardado, "El ejercicio creado no debería ser nulo.");

        // Ahora eliminamos el ejercicio
        boolean eliminado = ejercicioDAO.eliminarEjercicio(ejercicioGuardado.getId());
        assertTrue(eliminado, "El ejercicio debería haberse eliminado.");

        // Verificamos que el ejercicio fue eliminado
        Ejercicio ejercicioEliminado = ejercicioDAO.obtenerEjercicioNombre(ejercicioGuardado.getNombre());
        assertNull(ejercicioEliminado, "El ejercicio debería ser nulo después de la eliminación.");
    }
}
