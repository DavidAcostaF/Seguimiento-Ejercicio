package repository;

import dominio.Ejercicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EjercicioRepository {

    private List<Ejercicio> ejercicios = new ArrayList<>();  // Simulamos una base de datos en memoria

    // Método para guardar un nuevo ejercicio
    public Ejercicio save(Ejercicio ejercicio) {
        if (ejercicio.getId() == null) {
            // Asignamos un ID automáticamente si es nuevo
            ejercicio.setId((long) (ejercicios.size() + 1));
        }
        ejercicios.add(ejercicio);
        return ejercicio;
    }

    // Método para obtener todos los ejercicios
    public List<Ejercicio> findAll() {
        return new ArrayList<>(ejercicios);
    }

    // Método para buscar un ejercicio por ID
    public Ejercicio findById(Long id) {
        Optional<Ejercicio> ejercicio = ejercicios.stream().filter(e -> e.getId().equals(id)).findFirst();
        return ejercicio.orElse(null);
    }

    // Método para buscar un ejercicio por nombre
    public Ejercicio findByNombre(String nombre) {
        Optional<Ejercicio> ejercicio = ejercicios.stream().filter(e -> e.getNombre().equals(nombre)).findFirst();
        return ejercicio.orElse(null);
    }

    // Método para eliminar un ejercicio por ID
    public boolean deleteById(Long id) {
        return ejercicios.removeIf(ejercicio -> ejercicio.getId().equals(id));
    }
}
