package conversores;

import dominio.EjercicioDiario;
import dominio.Rutina;
import dtos.EjercicioDiarioDTO;
import dtos.RutinaDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que convierte entre la entidad Rutina y el DTO RutinaDTO.
 */
public class RutinaConversor implements IConversor<Rutina, RutinaDTO> {
    private DiaConversor conversorDia;
    private EjercicioDiarioConversor conversorEjercicioDiarios;
    private UsuarioConversor conversorUsuario;

    // Constructor que inicializa los conversores
    public RutinaConversor() {
        this.conversorDia = new DiaConversor();
        this.conversorEjercicioDiarios = new EjercicioDiarioConversor();
        this.conversorUsuario = new UsuarioConversor();
    }
    
    @Override
    public RutinaDTO EntidadADTO(Rutina entidad) {
        if (entidad == null) {
            return null; // Retorna null si la entidad es null
        }

        // Convierte la lista de ejercicios diarios de la entidad a una lista de DTOs
        List<EjercicioDiarioDTO> ejerciciosDiariosDTO = entidad.getEjerciciosDiarios().stream()
                .map(conversorEjercicioDiarios::EntidadADTO) // Usa el conversor para cada EjercicioDiario
                .collect(Collectors.toList()); // Recolecta el resultado en una lista

        // Crea el DTO utilizando los valores de la entidad
        return new RutinaDTO(
                entidad.getId(),
                ejerciciosDiariosDTO, // Lista de EjercicioDiarioDTO
                conversorUsuario.EntidadADTO(entidad.getUsuario()), // Conversión del Usuario
                conversorDia.EntidadADTO(entidad.getDia()) // Conversión del Dia
        );
    }

    @Override
    public Rutina DTOAEntidad(RutinaDTO dto) {
        if (dto == null) {
            return null; // Retorna null si el DTO es null
        }
        
        // Crea la entidad utilizando los valores del DTO
        return new Rutina(
            dto.id(),
            conversorUsuario.DTOAEntidad(dto.usuario()),
            conversorDia.DTOAEntidad(dto.dia())
        );
    }
}
