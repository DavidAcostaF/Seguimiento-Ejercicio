package conversores;

import dominio.EjercicioDiario;
import dominio.Rutina;
import dtos.EjercicioDiarioDTO;
import dtos.RutinaDTO;

/**
 * Clase que convierte entre la entidad EjercicioDiario y el DTO EjercicioDiarioDTO.
 */
public class EjercicioDiarioConversor implements IConversor<EjercicioDiario, EjercicioDiarioDTO> {
    private EjercicioConversor conversorEjercicio;
//    private RutinaConversor conversorRutina;
    
    public EjercicioDiarioConversor() {
        conversorEjercicio = new EjercicioConversor();
//        conversorRutina = new RutinaConversor();
    }

    @Override
    public EjercicioDiarioDTO EntidadADTO(EjercicioDiario entidad) {
        if (entidad == null) {
            return null; // Retorna null si la entidad es null
        }
        // Crea el DTO utilizando los valores de la entidad
        return new EjercicioDiarioDTO(
            entidad.getId(),
            conversorEjercicio.EntidadADTO(entidad.getEjercicio()), 
            entidad.isCompletado(),
            new RutinaDTO(entidad.getRutina().getId(),
                    null,
                    null,
                    null)
        );
    }

    @Override
    public EjercicioDiario DTOAEntidad(EjercicioDiarioDTO dto) {
        if (dto == null) {
            return null; // Retorna null si el DTO es null
        }
        // Crea la entidad utilizando los valores del DTO
        return new EjercicioDiario(
            conversorEjercicio.DTOAEntidad(dto.ejercicio()),
            dto.completado(),
            new Rutina(dto.rutina().id())
        );
    }
}
