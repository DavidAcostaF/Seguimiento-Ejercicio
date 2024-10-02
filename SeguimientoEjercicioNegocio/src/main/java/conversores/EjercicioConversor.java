package conversores;

import dominio.Ejercicio;
import dtos.EjercicioDTO;

/**
 * Clase conversora para transformar entre Ejercicio y EjercicioDTO.
 * Implementa la interfaz IConversor.
 * 
 * @author af_da
 */
public class EjercicioConversor implements IConversor<Ejercicio, EjercicioDTO> {

    @Override
    public EjercicioDTO EntidadADTO(Ejercicio entidad) {
        if (entidad == null) {
            return null; // Manejo de caso nulo
        }
        return new EjercicioDTO(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getDescripcion(),
            entidad.getSeries(),
            entidad.getRepeticiones()
        );
    }

    @Override
    public Ejercicio DTOAEntidad(EjercicioDTO dto) {
        if (dto == null) {
            return null; // Manejo de caso nulo
        }
        return new Ejercicio(
            dto.id(),
            dto.nombre(),
            dto.descripcion(),
            dto.series(),
            dto.repeticiones()
        );
    }
}
