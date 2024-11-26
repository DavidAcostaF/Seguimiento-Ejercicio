package mock;

import dominio.Ejercicio;
import negocio.EjercicioNegocio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import repository.EjercicioRepository;
import java.util.List;

public class EjercicioTest {

    private EjercicioNegocio ejercicioNegocio;  // Instancia de la clase negocio
    private EjercicioRepository ejercicioRepository;  // Instancia del repositorio

    @BeforeEach
    public void setUp() {
        // Inicializamos el repositorio mock y negocio antes de cada prueba
        ejercicioRepository = mock(EjercicioRepository.class);
        ejercicioNegocio = new EjercicioNegocio(ejercicioRepository);
    }

    @Test
    public void testCrearEjercicio() {
        System.out.println("Probando la creación de un ejercicio...");
        System.out.println("Descripción: Este test verifica que se pueda crear un ejercicio correctamente. " +
                "Se valida que al crear un ejercicio, se le asigne un ID y los valores sean los correctos.");

        // Creamos un ejercicio
        Ejercicio ejercicio = new Ejercicio("Flexiones", "Fuerza", 15.0f);
        
        // Simulamos que el repositorio guarda el ejercicio y asigna un ID
        when(ejercicioRepository.save(any(Ejercicio.class))).thenReturn(ejercicio);

        // Llamamos al método del negocio para crear el ejercicio
        Ejercicio ejercicioCreado = ejercicioNegocio.crearEjercicio(1L,"Flexiones", "Fuerza", 15.0f);

        // Verificamos que el ID no sea nulo
        assertNotNull(ejercicioCreado.getId(), "El ID no debe ser nulo después de guardar");

        // Verificamos que el nombre del ejercicio sea "Flexiones"
        assertEquals("Flexiones", ejercicioCreado.getNombre(), "El nombre del ejercicio debe ser Flexiones");

        // Verificamos que el repositorio fue llamado para guardar el ejercicio
        verify(ejercicioRepository, times(1)).save(any(Ejercicio.class));
    }

    @Test
    public void testObtenerTodosLosEjercicios() {
        System.out.println("Probando la obtención de todos los ejercicios...");
        System.out.println("Descripción: Este test verifica que se puedan obtener todos los ejercicios creados " +
                "previamente. Se crean varios ejercicios y se valida que la lista contenga los ejercicios correctos.");

        // Creamos varios ejercicios
        Ejercicio ejercicio1 = new Ejercicio(2L,"Flexiones", "Fuerza", 15.0f);
        Ejercicio ejercicio2 = new Ejercicio(3L,"Correr", "Cardio", 30.0f);
        
        // Simulamos que el repositorio devuelve una lista de ejercicios
        when(ejercicioRepository.findAll()).thenReturn(List.of(ejercicio1, ejercicio2));

        // Llamamos al método del negocio para obtener todos los ejercicios
        List<Ejercicio> ejercicios = ejercicioNegocio.obtenerTodosLosEjercicios();

        // Verificamos que la lista contiene 2 ejercicios
        assertEquals(2, ejercicios.size(), "Debe haber 2 ejercicios en la lista");

        // Verificamos que los nombres sean correctos
        assertEquals("Flexiones", ejercicios.get(0).getNombre(), "El primer ejercicio debe ser Flexiones");
        assertEquals("Correr", ejercicios.get(1).getNombre(), "El segundo ejercicio debe ser Correr");

        // Verificamos que el repositorio fue llamado para obtener todos los ejercicios
        verify(ejercicioRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorNombre() {
        System.out.println("Probando la búsqueda por nombre...");
        System.out.println("Descripción: Este test verifica que se pueda buscar un ejercicio por su nombre " +
                "y que se recupere el ejercicio correcto.");

        // Creamos y guardamos un ejercicio
        Ejercicio ejercicio = new Ejercicio(4L,"Flexiones", "Fuerza", 15.0f);


        // Llamamos al método del negocio para buscar el ejercicio por nombre
        Ejercicio ejercicioEncontrado = ejercicioNegocio.obtenerEjercicioPorNombre("Flexiones");

        // Verificamos que el ejercicio encontrado no sea nulo y su nombre sea correcto
        assertNotNull(ejercicioEncontrado, "El ejercicio encontrado no debe ser nulo");
        assertEquals("Flexiones", ejercicioEncontrado.getNombre(), "El nombre del ejercicio debe ser Flexiones");

    }

    @Test
    public void testEliminarEjercicio() {
        System.out.println("Probando la eliminación de un ejercicio...");
        System.out.println("Descripción: Este test verifica que un ejercicio creado pueda ser eliminado correctamente. " +
                "Se crea un ejercicio, se elimina y luego se valida que el ejercicio ya no exista en el repositorio.");

        // Creamos y guardamos un ejercicio
        Ejercicio ejercicio = new Ejercicio(3L,"Flexiones", "Fuerza", 15.0f);
        
        // Simulamos que el repositorio devuelve el ejercicio eliminado correctamente
        doNothing().when(ejercicioRepository).deleteById(anyLong());

        // Llamamos al método del negocio para eliminar el ejercicio
        ejercicioNegocio.eliminarEjercicio(ejercicio.getId());

        // Verificamos que el repositorio fue llamado para eliminar el ejercicio
        verify(ejercicioRepository, times(1)).deleteById(ejercicio.getId());
    }
}
