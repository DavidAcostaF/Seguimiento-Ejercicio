package conversores;

import dominio.Dia;
import dominio.DiaSemana;
import dtos.DiaDTO;

/**
 *
 * @author af_da
 */
public class DiaConversor implements IConversor<Dia, DiaDTO> {

    @Override
    public DiaDTO EntidadADTO(Dia entidad) {
        if (entidad == null) {
            return null; // Retorna null si la entidad es nula
        }

        DiaDTO dto = new DiaDTO(entidad.getId(),entidad.getNombre().name());


        return dto; // Retorna el DTO
    }

    @Override
    public Dia DTOAEntidad(DiaDTO dto) {
        if (dto == null) {
            return null; // Retorna null si el DTO es nulo
        }

        Dia dia = new Dia(dto.id(),DiaSemana.valueOf(dto.nombre()));

        return dia; // Retorna la entidad
    }
}
