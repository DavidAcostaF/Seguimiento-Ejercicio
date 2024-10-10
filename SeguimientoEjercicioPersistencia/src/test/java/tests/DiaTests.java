package tests;
import daos.IDiaDAO;
import daos.DiaDAO;
import dominio.Dia;
import dominio.DiaSemana;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiaTests {

    @Test
    public void testGetOrCreate() {
        IDiaDAO diaDAO = new DiaDAO(); // Inicializa el DAO dentro del test
        EntityManager em = Persistence.createEntityManagerFactory("SeguimientoEjercicioPU").createEntityManager();

        // Agregar todos los días de la semana
        for (DiaSemana diaSemana : DiaSemana.values()) {
            diaDAO.getOrCreate(em, diaSemana);
        }

        // Verificar que todos los días están en la base de datos
        for (DiaSemana diaSemana : DiaSemana.values()) {
            Dia dia = diaDAO.getOrCreate(em, diaSemana);
            assertNotNull(dia, "El día " + diaSemana + " no debería ser nulo.");
            assertEquals(diaSemana, dia.getNombre(), "El día debería ser " + diaSemana + ".");
        }

        // Eliminar todos los días de la semana
        for (DiaSemana diaSemana : DiaSemana.values()) {
            Dia dia = diaDAO.getOrCreate(em, diaSemana);
            diaDAO.eliminar(dia.getId());
        }

        em.close(); // Cerramos el EntityManager
    }

    @Test
    public void testLista() {
        IDiaDAO diaDAO = new DiaDAO(); // Inicializa el DAO dentro del test
        EntityManager em = Persistence.createEntityManagerFactory("SeguimientoEjercicioPU").createEntityManager();

        // Agregar todos los días de la semana
        for (DiaSemana diaSemana : DiaSemana.values()) {
            diaDAO.getOrCreate(em, diaSemana);
        }

        // Verificamos que la lista de días se obtenga correctamente
        List<Dia> dias = diaDAO.lista();
        System.out.println(dias);
        assertFalse(dias.isEmpty(), "La lista de días no debería estar vacía.");
        assertEquals(DiaSemana.values().length, dias.size(), "Debería haber un día para cada día de la semana.");

        // Eliminar todos los días de la semana
        for (DiaSemana diaSemana : DiaSemana.values()) {
            Dia dia = diaDAO.getOrCreate(em, diaSemana);
            diaDAO.eliminar(dia.getId());
        }

        em.close(); // Cerramos el EntityManager
    }

    @Test
    public void testEliminar() {
        IDiaDAO diaDAO = new DiaDAO(); // Inicializa el DAO dentro del test
        EntityManager em = Persistence.createEntityManagerFactory("SeguimientoEjercicioPU").createEntityManager();

        // Agregar todos los días de la semana
        for (DiaSemana diaSemana : DiaSemana.values()) {
            diaDAO.getOrCreate(em, diaSemana);
        }

        // Eliminar un día específico
        Dia dia = diaDAO.getOrCreate(em, DiaSemana.VIERNES);
        Long idDia = dia.getId();
        assertNotNull(dia, "El día creado no debería ser nulo.");

        // Ahora eliminamos el día creado
        boolean eliminado = diaDAO.eliminar(idDia);
        assertTrue(eliminado, "El día debería haberse eliminado.");


        // Eliminar todos los días restantes de la semana
        for (DiaSemana diaSemana : DiaSemana.values()) {
            if (!diaSemana.equals(DiaSemana.VIERNES)) { // Evitar eliminar el día que ya hemos eliminado
                Dia diaRestante = diaDAO.getOrCreate(em, diaSemana);
                diaDAO.eliminar(diaRestante.getId());
            }
        }

        em.close(); // Cerramos el EntityManager
    }
}
