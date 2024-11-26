package negocio;

import dominio.Rutina;
import repository.RutinaRepository;
import java.util.List;

public class RutinaNegocio {

    private RutinaRepository rutinaRepository;

    // Constructor
    public RutinaNegocio(RutinaRepository rutinaRepository) {
        this.rutinaRepository = rutinaRepository;
    }

    // Método para crear una nueva Rutina
    public Rutina crearRutina(Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    // Método para obtener todas las Rutinas
    public List<Rutina> obtenerTodasLasRutinas() {
        return rutinaRepository.findAll();
    }

    // Método para obtener una Rutina por ID
    public Rutina obtenerRutinaPorId(Long id) {
        return rutinaRepository.findById(id);
    }

    // Método para eliminar una Rutina
    public boolean eliminarRutina(Long id) {
        return rutinaRepository.deleteById(id);
    }
}
