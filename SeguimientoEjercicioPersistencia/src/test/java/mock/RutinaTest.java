package mock;

import dominio.Rutina;
import dominio.EjercicioDiario;
import dominio.Usuario;
import dominio.Dia;
import dominio.DiaSemana;
import negocio.RutinaNegocio;
import repository.RutinaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RutinaTest {

    private RutinaNegocio rutinaNegocio;
    private RutinaRepository rutinaRepository;

    @BeforeEach
    public void setUp() {
        // Inicializamos el repositorio y negocio antes de cada prueba usando mocks
        rutinaRepository = mock(RutinaRepository.class);
        rutinaNegocio = new RutinaNegocio(rutinaRepository);
    }

    @Test
    public void testCrearRutina() {
        System.out.println("Iniciando testCrearRutina: Verifica la creación de una rutina.");

        // Creamos un usuario con id y nombre
        Usuario usuario = new Usuario(1L, "David");

        // Creamos un día usando el enum DiaSemana
        Dia dia = new Dia(DiaSemana.LUNES);

        // Creamos una nueva rutina
        Rutina rutina = new Rutina(1L,usuario,dia);

        // Simulamos que el repositorio guarda la rutina correctamente
        when(rutinaRepository.save(any(Rutina.class))).thenReturn(rutina);

        // Guardamos la rutina
        rutina = rutinaNegocio.crearRutina(rutina);

        // Verificamos que el ID no sea nulo
        assertNotNull(rutina.getId(), "El ID de la rutina no debe ser nulo después de guardar");

        // Verificamos que el usuario esté asignado correctamente
        assertEquals(usuario, rutina.getUsuario(), "El usuario asignado a la rutina debe ser el correcto");

        // Verificamos que el día esté asignado correctamente
        assertEquals(dia, rutina.getDia(), "El día asignado a la rutina debe ser el correcto");

        // Verificamos que se haya llamado al repositorio para guardar la rutina
        verify(rutinaRepository, times(1)).save(rutina);
    }

    @Test
    public void testObtenerTodasLasRutinas() {
        System.out.println("Iniciando testObtenerTodasLasRutinas: Verifica la obtención de todas las rutinas.");

        // Creamos usuarios con id y nombre
        Usuario usuario1 = new Usuario(1L, "David");
        Usuario usuario2 = new Usuario(2L, "Ana");

        // Creamos días usando el enum DiaSemana
        Dia dia1 = new Dia(DiaSemana.LUNES);
        Dia dia2 = new Dia(DiaSemana.MARTES);

        // Creamos las rutinas
        Rutina rutina1 = new Rutina(3L,usuario1, dia1);
        Rutina rutina2 = new Rutina(4L,usuario2, dia2);

        // Simulamos que el repositorio devuelve las rutinas
        when(rutinaRepository.findAll()).thenReturn(List.of(rutina1, rutina2));

        // Obtenemos todas las rutinas
        List<Rutina> rutinas = rutinaNegocio.obtenerTodasLasRutinas();

        // Verificamos que la lista contenga 2 rutinas
        assertEquals(2, rutinas.size(), "Debe haber 2 rutinas en la lista");

        // Verificamos los usuarios asignados a las rutinas
        assertEquals(usuario1, rutinas.get(0).getUsuario(), "La primera rutina debe tener el usuario correcto");
        assertEquals(usuario2, rutinas.get(1).getUsuario(), "La segunda rutina debe tener el usuario correcto");

        // Verificamos que el repositorio fue llamado correctamente
        verify(rutinaRepository, times(1)).findAll();
    }

    @Test
    public void testEliminarRutina() {
        System.out.println("Iniciando testEliminarRutina: Verifica la eliminación de una rutina.");

        // Creamos un usuario con id y nombre
        Usuario usuario = new Usuario(1L, "David");

        // Creamos un día usando el enum DiaSemana
        Dia dia = new Dia(DiaSemana.LUNES);

        // Creamos una rutina
        Rutina rutina = new Rutina(4L,usuario, dia);
        rutina = new Rutina(1L, usuario, dia);

        // Simulamos que el repositorio elimina la rutina correctamente
        when(rutinaRepository.deleteById(anyLong())).thenReturn(true);

        // Eliminamos la rutina
        boolean eliminado = rutinaNegocio.eliminarRutina(rutina.getId());

        // Verificamos que la rutina fue eliminada correctamente
        assertTrue(eliminado, "La rutina debe eliminarse correctamente");

        // Verificamos que se haya llamado al repositorio para eliminar la rutina
        verify(rutinaRepository, times(1)).deleteById(rutina.getId());
    }
}
