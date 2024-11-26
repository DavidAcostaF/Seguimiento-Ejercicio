package repository;

import dominio.Rutina;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RutinaRepository {

    private List<Rutina> rutinas = new ArrayList<>();  // Simulamos una base de datos en memoria

    // Método para guardar una nueva Rutina
    public Rutina save(Rutina rutina) {
        if (rutina.getId() == null) {
            // Asignamos un ID automáticamente si es nuevo
            rutina.setId((long) (rutinas.size() + 1));
        }
        rutinas.add(rutina);
        return rutina;
    }

    // Método para obtener todas las Rutinas
    public List<Rutina> findAll() {
        return new ArrayList<>(rutinas);
    }

    // Método para obtener una Rutina por ID
    public Rutina findById(Long id) {
        Optional<Rutina> rutina = rutinas.stream().filter(r -> r.getId().equals(id)).findFirst();
        return rutina.orElse(null);
    }

    // Método para eliminar una Rutina por ID (simulando soft delete)
    public boolean deleteById(Long id) {
        return rutinas.removeIf(rutina -> rutina.getId().equals(id));
    }
}
