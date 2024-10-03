package conversores;

import dominio.Ejercicio;
import dominio.Usuario;
import dtos.EjercicioDTO;

/**
 * Clase conversora para transformar entre Ejercicio y EjercicioDTO.
 * Implementa la interfaz IConversor.
 * 
 * @author af_da
 */
public class EjercicioConversor implements IConversor<Ejercicio, EjercicioDTO> {
    public UsuarioConversor conversorUsuario;
    
    public EjercicioConversor() {
        this.conversorUsuario = new UsuarioConversor();
    }
    
    @Override
    public EjercicioDTO EntidadADTO(Ejercicio entidad) {
        if (entidad == null) {
            return null; // Manejo de caso nulo
        }
        return new EjercicioDTO(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getTipo(),
            entidad.getDuracion()
//            conversorUsuario.EntidadADTO(entidad.getUsuario()) // Obtenemos el id del usuario
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
            dto.tipo(),
            dto.duracion()
//            conversorUsuario.DTOAEntidad(dto.usuario())// Asignamos el usuario a la entidad
        );
    }
}
