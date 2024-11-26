package negocio;

import dominio.EjercicioDiario;
import repository.EjercicioDiarioRepository;
import java.util.List;

public class EjercicioDiarioNegocio {

    private EjercicioDiarioRepository ejercicioDiarioRepository;

    // Constructor
    public EjercicioDiarioNegocio(EjercicioDiarioRepository ejercicioDiarioRepository) {
        this.ejercicioDiarioRepository = ejercicioDiarioRepository;
    }

    // Método para crear un nuevo EjercicioDiario
    public EjercicioDiario crearEjercicioDiario(EjercicioDiario ejercicioDiario) {
        return ejercicioDiarioRepository.save(ejercicioDiario);
    }

    // Método para obtener todos los EjerciciosDiarios
    public List<EjercicioDiario> obtenerTodosLosEjerciciosDiarios() {
        return ejercicioDiarioRepository.findAll();
    }

    // Método para obtener un EjercicioDiario por ID
    public EjercicioDiario obtenerEjercicioDiarioPorId(Long id) {
        return ejercicioDiarioRepository.findById(id);
    }

    // Método para eliminar un EjercicioDiario
    public boolean eliminarEjercicioDiario(Long id) {
        return ejercicioDiarioRepository.deleteById(id);
    }

    // Método para realizar un soft delete de un EjercicioDiario
    public void realizarSoftDelete(Long id) {
        EjercicioDiario ejercicioDiario = ejercicioDiarioRepository.findById(id);
        if (ejercicioDiario != null) {
            ejercicioDiario.softDelete();
            ejercicioDiarioRepository.save(ejercicioDiario);  // Guardamos los cambios
        }
    }
}
