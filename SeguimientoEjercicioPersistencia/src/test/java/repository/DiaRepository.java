package repository;

import dominio.Dia;
import dominio.DiaSemana;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiaRepository {

    private List<Dia> dias = new ArrayList<>();

    // Guardar o actualizar un día
    public Dia save(Dia dia) {
        // Simulamos una base de datos agregando el día a la lista
        if (dia.getId() == null) {
            dia.setId((long) (dias.size() + 1));  // Asignar un ID incremental
        }
        dias.add(dia);
        return dia;
    }

    // Obtener todos los días
    public List<Dia> findAll() {
        return dias;
    }

    // Buscar un día por su ID
    public Dia findById(Long id) {
        return dias.stream().filter(dia -> dia.getId().equals(id)).findFirst().orElse(null);
    }

    // Buscar un día por su nombre
    public Dia findByNombre(DiaSemana nombre) {
        return dias.stream().filter(dia -> dia.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    // Eliminar un día
    public void delete(Dia dia) {
        dias.remove(dia);
    }
}
