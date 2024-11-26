package mock;

import dominio.Dia;
import dominio.DiaSemana;
import negocio.DiaNegocio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import repository.DiaRepository;

public class DiaTest {

    private DiaNegocio diaNegocio;  // Instancia de la clase negocio
    private DiaRepository diaRepository;  // Instancia del repositorio

    @BeforeEach
    public void setUp() {
        // Inicializamos el repositorio y negocio antes de cada prueba
        diaRepository = new DiaRepository();
        diaNegocio = new DiaNegocio(diaRepository);
    }

    @Test
    public void testCrearDia() {
        // Impresión en consola al inicio del test
        System.out.println("Probando la creación de un día...");
        System.out.println("Descripción: Este test verifica que la creación de un día funcione correctamente. Se " +
                "valida que se pueda crear un día de la semana, como LUNES, y que se asignen los valores adecuados. " +
                "Se verifica que el ID no sea nulo y que el nombre del día sea el esperado.");
        
        // Crear un día (LUNES)
        Dia dia = diaNegocio.crearDia(DiaSemana.LUNES);

        // Verificamos que el ID no sea nulo
        assertNotNull(dia.getId(), "El ID no debe ser nulo después de guardar");

        // Verificamos que el nombre del día sea LUNES
        assertEquals(DiaSemana.LUNES, dia.getNombre(), "El nombre del día debe ser LUNES");
    }

    @Test
    public void testObtenerTodosLosDias() {
        // Impresión en consola al inicio del test
        System.out.println("Probando la obtención de todos los días...");
        System.out.println("Descripción: Este test verifica que se puedan obtener todos los días creados previamente. " +
                "Se crean algunos días, se obtienen todos y se comprueba que la lista contenga los días correctos " +
                "y que los nombres coincidan con los esperados.");
        
        // Creamos varios días
        diaNegocio.crearDia(DiaSemana.LUNES);
        diaNegocio.crearDia(DiaSemana.MARTES);

        // Obtenemos todos los días
        var dias = diaNegocio.obtenerTodosLosDias();

        // Verificamos que la lista contiene 2 días
        assertEquals(2, dias.size(), "Debe haber 2 días en la lista");

        // Verificamos que los nombres sean correctos
        assertEquals(DiaSemana.LUNES, dias.get(0).getNombre(), "El primer día debe ser LUNES");
        assertEquals(DiaSemana.MARTES, dias.get(1).getNombre(), "El segundo día debe ser MARTES");
    }

    @Test
    public void testBuscarPorNombre() {
        // Impresión en consola al inicio del test
        System.out.println("Probando la búsqueda por nombre...");
        System.out.println("Descripción: Este test verifica que se pueda buscar un día por su nombre. Se crea un día, " +
                "se guarda y luego se busca por su nombre. Se valida que el día encontrado sea el correcto y no sea nulo.");
        
        // Creamos y guardamos un día (MIERCOLES)
        Dia dia = diaNegocio.crearDia(DiaSemana.MIERCOLES);

        // Buscamos el día por su nombre
        Dia diaEncontrado = diaNegocio.obtenerDiaPorNombre(DiaSemana.MIERCOLES);

        // Verificamos que el día encontrado no sea nulo y su nombre sea correcto
        assertNotNull(diaEncontrado, "El día encontrado no debe ser nulo");
        assertEquals(DiaSemana.MIERCOLES, diaEncontrado.getNombre(), "El nombre del día debe ser MIERCOLES");
    }

    @Test
    public void testEliminarDia() {
        // Impresión en consola al inicio del test
        System.out.println("Probando la eliminación de un día...");
        System.out.println("Descripción: Este test verifica que un día creado pueda ser eliminado correctamente. " +
                "Se crea un día, se elimina y luego se valida que el día ya no exista en el repositorio.");
        
        // Creamos y guardamos un día (JUEVES)
        Dia dia = diaNegocio.crearDia(DiaSemana.JUEVES);

        // Eliminamos el día
        diaNegocio.eliminarDia(dia);

        // Verificamos que el día ya no esté presente en el repositorio
        Dia diaEliminado = diaRepository.findById(dia.getId());
        assertNull(diaEliminado, "El día debe haber sido eliminado y no debe existir");
    }
}
