package mock;

import dominio.Ejercicio;
import dominio.EjercicioDiario;
import dominio.Rutina;
import negocio.EjercicioDiarioNegocio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import repository.EjercicioDiarioRepository;

import java.util.List;

public class EjercicioDiarioTest {

    private EjercicioDiarioNegocio ejercicioDiarioNegocio;  // Instancia de la clase negocio
    private EjercicioDiarioRepository ejercicioDiarioRepository;  // Instancia del repositorio

    @BeforeEach
    public void setUp() {
        // Inicializamos el repositorio y negocio antes de cada prueba
        ejercicioDiarioRepository = new EjercicioDiarioRepository();
        ejercicioDiarioNegocio = new EjercicioDiarioNegocio(ejercicioDiarioRepository);
    }

    @Test
    public void testCrearEjercicioDiario() {
        // Impresión en consola al inicio del test
        System.out.println("Probando la creación de un Ejercicio Diario...");
        System.out.println("Descripción: Este test verifica que se pueda crear un EjercicioDiario correctamente. "
                + "Se valida que al crear un EjercicioDiario, se le asigne un ID y que los valores sean los correctos.");

        // Creamos un ejercicio y una rutina
        Ejercicio ejercicio = new Ejercicio("Flexiones", "Fuerza", 15.0f);
        Rutina rutina = new Rutina(1L);

        // Creamos un EjercicioDiario
        EjercicioDiario ejercicioDiario = new EjercicioDiario(ejercicio, true, rutina);

        // Guardamos el EjercicioDiario
        ejercicioDiario = ejercicioDiarioNegocio.crearEjercicioDiario(ejercicioDiario);

        // Verificamos que el ID no sea nulo
        assertNotNull(ejercicioDiario.getId(), "El ID no debe ser nulo después de guardar");

        // Verificamos que el ejercicio esté marcado como completado
        assertTrue(ejercicioDiario.isCompletado(), "El ejercicio debe estar marcado como completado");
    }

    @Test
    public void testObtenerTodosLosEjerciciosDiarios() {
        // Impresión en consola al inicio del test
        System.out.println("Probando la obtención de todos los Ejercicios Diarios...");
        System.out.println("Descripción: Este test verifica que se puedan obtener todos los ejercicios diarios creados "
                + "previamente. Se crean varios EjerciciosDiarios y se valida que la lista contenga los ejercicios correctos.");

        // Creamos ejercicios y rutinas
        Ejercicio ejercicio1 = new Ejercicio("Flexiones", "Fuerza", 15.0f);
        Ejercicio ejercicio2 = new Ejercicio("Correr", "Cardio", 30.0f);
        Rutina rutina1 = new Rutina(1L);
        Rutina rutina2 = new Rutina(2L);

        ejercicioDiarioNegocio.crearEjercicioDiario(new EjercicioDiario(ejercicio1, true, rutina1));
        ejercicioDiarioNegocio.crearEjercicioDiario(new EjercicioDiario(ejercicio2, false, rutina2));

        // Obtenemos todos los EjerciciosDiarios
        List<EjercicioDiario> ejerciciosDiarios = ejercicioDiarioNegocio.obtenerTodosLosEjerciciosDiarios();

        // Verificamos que la lista contiene 2 EjerciciosDiarios
        assertEquals(2, ejerciciosDiarios.size(), "Debe haber 2 EjerciciosDiarios en la lista");

        // Verificamos los nombres de los ejercicios
        assertEquals("Flexiones", ejerciciosDiarios.get(0).getEjercicio().getNombre(), "El primer ejercicio debe ser Flexiones");
        assertEquals("Correr", ejerciciosDiarios.get(1).getEjercicio().getNombre(), "El segundo ejercicio debe ser Correr");
    }

    @Test
    public void testSoftDeleteEjercicioDiario() {
        // Impresión en consola al inicio del test
        System.out.println("Probando el soft delete de un Ejercicio Diario...");
        System.out.println("Descripción: Este test verifica que un EjercicioDiario creado pueda ser eliminado correctamente "
                + "mediante un soft delete. El registro debería marcarse como inactivo en lugar de eliminarse físicamente.");

        // Creamos un ejercicio y rutina
        Ejercicio ejercicio = new Ejercicio("Flexiones", "Fuerza", 15.0f);
        Rutina rutina = new Rutina(3L);

        // Creamos un EjercicioDiario
        EjercicioDiario ejercicioDiario = new EjercicioDiario(ejercicio, true, rutina);
        ejercicioDiario = ejercicioDiarioNegocio.crearEjercicioDiario(ejercicioDiario);

        // Realizamos el soft delete
        ejercicioDiarioNegocio.realizarSoftDelete(ejercicioDiario.getId());

        // Verificamos que el ejercicio está marcado como inactivo
        EjercicioDiario ejercicioEliminado = ejercicioDiarioNegocio.obtenerEjercicioDiarioPorId(ejercicioDiario.getId());
        assertFalse(ejercicioEliminado.isActivo(), "El ejercicio debe estar marcado como inactivo tras el soft delete");
    }
}
