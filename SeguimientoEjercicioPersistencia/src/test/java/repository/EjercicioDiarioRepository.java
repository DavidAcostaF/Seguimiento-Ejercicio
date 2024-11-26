package repository;

import dominio.EjercicioDiario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EjercicioDiarioRepository {

    private List<EjercicioDiario> ejerciciosDiarios = new ArrayList<>();  // Simulamos una base de datos en memoria

    // Método para guardar un nuevo EjercicioDiario
    public EjercicioDiario save(EjercicioDiario ejercicioDiario) {
        if (ejercicioDiario.getId() == null) {
            // Asignamos un ID automáticamente si es nuevo
            ejercicioDiario.setId((long) (ejerciciosDiarios.size() + 1));
        }
        ejerciciosDiarios.add(ejercicioDiario);
        return ejercicioDiario;
    }

    // Método para obtener todos los EjerciciosDiarios
    public List<EjercicioDiario> findAll() {
        return new ArrayList<>(ejerciciosDiarios);
    }

    // Método para obtener un EjercicioDiario por ID
    public EjercicioDiario findById(Long id) {
        Optional<EjercicioDiario> ejercicioDiario = ejerciciosDiarios.stream().filter(e -> e.getId().equals(id)).findFirst();
        return ejercicioDiario.orElse(null);
    }

    // Método para eliminar un EjercicioDiario por ID (simulando soft delete)
    public boolean deleteById(Long id) {
        return ejerciciosDiarios.removeIf(ejercicioDiario -> ejercicioDiario.getId().equals(id));
    }
}
