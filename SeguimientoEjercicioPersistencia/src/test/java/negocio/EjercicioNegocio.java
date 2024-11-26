package negocio;

import dominio.Ejercicio;
import repository.EjercicioRepository;
import java.util.List;

public class EjercicioNegocio {

    private EjercicioRepository ejercicioRepository;

    // Constructor
    public EjercicioNegocio(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    // Método para crear un nuevo ejercicio
    public Ejercicio crearEjercicio(Long id, String nombre, String tipo, float duracion) {
        Ejercicio ejercicio = new Ejercicio(id,nombre, tipo, duracion);
        return ejercicioRepository.save(ejercicio);
    }

    // Método para obtener todos los ejercicios
    public List<Ejercicio> obtenerTodosLosEjercicios() {
        return ejercicioRepository.findAll();
    }

    // Método para buscar un ejercicio por su nombre
    public Ejercicio obtenerEjercicioPorNombre(String nombre) {
        return ejercicioRepository.findByNombre(nombre);
    }

    // Método para eliminar un ejercicio
    public boolean eliminarEjercicio(Long id) {
        return ejercicioRepository.deleteById(id);
    }

    // Método para obtener un ejercicio por ID
    public Ejercicio obtenerEjercicioPorId(Long id) {
        return ejercicioRepository.findById(id);
    }
}
