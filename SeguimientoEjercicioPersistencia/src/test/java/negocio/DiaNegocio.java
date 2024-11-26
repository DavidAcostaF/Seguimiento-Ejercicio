package negocio;

import dominio.Dia;
import dominio.DiaSemana;
import java.util.List;
import repository.DiaRepository;

public class DiaNegocio {

    private DiaRepository diaRepository;

    // Constructor
    public DiaNegocio(DiaRepository diaRepository) {
        this.diaRepository = diaRepository;
    }

    // Crear un día
    public Dia crearDia(DiaSemana nombre) {
        Dia dia = new Dia(nombre);
        return diaRepository.save(dia);
    }

    // Obtener todos los días
    public List<Dia> obtenerTodosLosDias() {
        return diaRepository.findAll();
    }

    // Buscar un día por nombre
    public Dia obtenerDiaPorNombre(DiaSemana nombre) {
        return diaRepository.findByNombre(nombre);
    }

    // Eliminar un día
    public void eliminarDia(Dia dia) {
        diaRepository.delete(dia);
    }
}
